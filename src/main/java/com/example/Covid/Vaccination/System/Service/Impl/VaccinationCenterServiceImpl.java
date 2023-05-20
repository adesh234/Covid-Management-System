package com.example.Covid.Vaccination.System.Service.Impl;

import com.example.Covid.Vaccination.System.DTO.Request.CenterRequest;
import com.example.Covid.Vaccination.System.DTO.Response.CenterResponse;
import com.example.Covid.Vaccination.System.Enum.CenterType;
import com.example.Covid.Vaccination.System.Exception.NoCenterException;
import com.example.Covid.Vaccination.System.Model.Doctor;
import com.example.Covid.Vaccination.System.Model.VaccinationCenter;
import com.example.Covid.Vaccination.System.Repository.VaccinationCenterRepository;
import com.example.Covid.Vaccination.System.Service.VaccinationCenterService;
import com.example.Covid.Vaccination.System.Transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Override
    public CenterResponse addCenter(CenterRequest centerRequest) {
        VaccinationCenter vaccinationCenter = CenterTransformer.RequestDtoToCenter(centerRequest);
        VaccinationCenter vaccinationCenter1 = vaccinationCenterRepository.save(vaccinationCenter);
        return CenterTransformer.CenterToResponse(vaccinationCenter1);
    }

    @Override
    public List<String> getDoctorsAtCenter(int id) throws NoCenterException {
        VaccinationCenter center;
        try{
            center = vaccinationCenterRepository.findById(id).get();
        }
        catch (Exception e){
            throw new NoCenterException("No Such Center");
        }
        List<String> doctors = new ArrayList<>();
        List<Doctor> doctorList = center.getDoctors();
        for(Doctor doctor: doctorList)
            doctors.add(doctor.getName());

        return doctors;
    }

    @Override
    public List<CenterResponse> getAllCenterOfType(CenterType centerType) {
        String centerType1 = String.valueOf(centerType);
        List<VaccinationCenter> list = vaccinationCenterRepository.getAllCenterOfType(centerType1);
        List<CenterResponse> centerResponses = new ArrayList<>();
        for(VaccinationCenter vaccinationCenter: list)
            centerResponses.add(CenterTransformer.CenterToResponse(vaccinationCenter));

        return centerResponses;
    }
}
