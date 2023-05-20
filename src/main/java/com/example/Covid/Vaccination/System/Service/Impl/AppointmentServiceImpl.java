package com.example.Covid.Vaccination.System.Service.Impl;

import com.example.Covid.Vaccination.System.DTO.Request.AppointmentRequest;
import com.example.Covid.Vaccination.System.DTO.Response.AppointmentResponse;
import com.example.Covid.Vaccination.System.Enum.DoseNo;
import com.example.Covid.Vaccination.System.Exception.NoDoctorException;
import com.example.Covid.Vaccination.System.Exception.NoPersonException;
import com.example.Covid.Vaccination.System.Exception.NotEligibleForDoseException;
import com.example.Covid.Vaccination.System.Model.*;
import com.example.Covid.Vaccination.System.Repository.AppointmentRepository;
import com.example.Covid.Vaccination.System.Repository.DoctorRepository;
import com.example.Covid.Vaccination.System.Repository.PersonRepository;
import com.example.Covid.Vaccination.System.Service.AppointmentService;
import com.example.Covid.Vaccination.System.Service.Dose1Service;
import com.example.Covid.Vaccination.System.Service.Dose2Service;
import com.example.Covid.Vaccination.System.Transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;

    @Override
    public AppointmentResponse addAppointment(AppointmentRequest appointmentRequest) throws NoPersonException, NoDoctorException, NotEligibleForDoseException {
        Optional<Person> personOptional = personRepository.findById(appointmentRequest.getPersonId());
        if(!personOptional.isPresent()){
            throw new NoPersonException("No Such Person");
        }
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentRequest.getDoctorId());
        if(!doctorOptional.isPresent()){
            throw new NoDoctorException("No Such Doctor");
        }
        Person person = personOptional.get();
        Doctor doctor = doctorOptional.get();

        if(appointmentRequest.getDoseNo().equals(DoseNo.DOSE_1)){
            Dose1 dose1 = dose1Service.createDose1(person,appointmentRequest.getVaccineType());
            person.setDose1Status(true);
            person.setDose1(dose1);
        }
        else{
            Dose2 dose2 = dose2Service.createDose2(person,appointmentRequest.getVaccineType());
            if(!person.isDose1Status())
                throw new NotEligibleForDoseException("First take Dose 1");
            person.setDose2Status(true);
            person.setDose2(dose2);
        }
        Appointment appointment = AppointmentTransformer.RequestToAppointment(appointmentRequest,person,doctor);
        person.getAppointments().add(appointment);

        Person savedPerson = personRepository.save(person);//saves person, dose1 ,dose2 & appointment
        Appointment savedAppointment = savedPerson.getAppointments().get(savedPerson.getAppointments().size()-1);
        doctor.getAppointmentList().add(savedAppointment);
        doctorRepository.save(doctor);
        return AppointmentTransformer.AppointmentToResponse(savedAppointment,person,doctor,appointmentRequest.getVaccineType());

    }
}