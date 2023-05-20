package com.example.Covid.Vaccination.System.Service.Impl;

import com.example.Covid.Vaccination.System.DTO.Request.DoctorRequest;
import com.example.Covid.Vaccination.System.DTO.Response.CenterResponse;
import com.example.Covid.Vaccination.System.DTO.Response.DoctorResponse;
import com.example.Covid.Vaccination.System.Enum.Gender;
import com.example.Covid.Vaccination.System.Exception.NoCenterException;
import com.example.Covid.Vaccination.System.Model.Doctor;
import com.example.Covid.Vaccination.System.Model.VaccinationCenter;
import com.example.Covid.Vaccination.System.Repository.DoctorRepository;
import com.example.Covid.Vaccination.System.Repository.VaccinationCenterRepository;
import com.example.Covid.Vaccination.System.Service.DoctorService;
import com.example.Covid.Vaccination.System.Transformer.CenterTransformer;
import com.example.Covid.Vaccination.System.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Override
    public DoctorResponse addDoctor(DoctorRequest doctorRequest) throws NoCenterException {
        VaccinationCenter vaccinationCenter;
        try{
            vaccinationCenter = vaccinationCenterRepository.findById(doctorRequest.getCenterId()).get();

        }
        catch (Exception e){
            throw new NoCenterException("No Such Center");
        }

        Doctor doctor = DoctorTransformer.RequestToDoctor(doctorRequest);
        doctor.setVaccinationCenter(vaccinationCenter);
        vaccinationCenter.getDoctors().add(doctor);
        VaccinationCenter center = vaccinationCenterRepository.save(vaccinationCenter);

        CenterResponse centerResponse = CenterTransformer.CenterToResponse(center);
        return DoctorTransformer.DoctorToResponse(doctor);
    }

    @Override
    public List<DoctorResponse> getAllAppointmentMoreThan10() {
        List<Doctor> list = doctorRepository.findAll();
        List<DoctorResponse> responseList = new ArrayList<>();
        for(Doctor doctor: list){
            if(doctor.getAppointmentList().size()>10){
                responseList.add(DoctorTransformer.DoctorToResponse(doctor));
            }
        }
        return responseList;
    }

    @Override
    public List<DoctorResponse> getAllMaleMoreThan40() {
        List<Doctor> list = doctorRepository.getAllMaleMoreThan40();
        List<DoctorResponse> responseList = new ArrayList<>();
        for(Doctor doctor: list){
            responseList.add(DoctorTransformer.DoctorToResponse(doctor));
        }
        return responseList;
    }

    @Override
    public String getRatioMaleToFemale() {
        List<Doctor> list = doctorRepository.findAll();
        int male=0,female=0;
        for(Doctor doctor: list){
            if(doctor.getGender().equals(Gender.MALE)) male++;
            else if(doctor.getGender().equals(Gender.FEMALE)) female++;
        }
        if(female==0) return "Male : "+ male +" // No Female";
        if(male==0) return "Female : "+ female +" // No Male";

        return String.valueOf(male/female);
    }
}