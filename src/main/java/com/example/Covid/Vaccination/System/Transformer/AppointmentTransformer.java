package com.example.Covid.Vaccination.System.Transformer;

import com.example.Covid.Vaccination.System.DTO.Request.AppointmentRequest;
import com.example.Covid.Vaccination.System.DTO.Response.AppointmentResponse;
import com.example.Covid.Vaccination.System.DTO.Response.CenterResponse;
import com.example.Covid.Vaccination.System.Enum.VaccineType;
import com.example.Covid.Vaccination.System.Model.Appointment;
import com.example.Covid.Vaccination.System.Model.Doctor;
import com.example.Covid.Vaccination.System.Model.Person;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class AppointmentTransformer {
    public Appointment RequestToAppointment(AppointmentRequest appointmentRequest, Person person, Doctor doctor){
        return Appointment.builder()
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appointmentRequest.getDoseNo())
                .person(person)
                .doctor(doctor)
                .build();
    }
    public AppointmentResponse AppointmentToResponse(Appointment appointment, Person person, Doctor doctor, VaccineType vaccineType){
        CenterResponse centerResponse = CenterTransformer.CenterToResponse(doctor.getVaccinationCenter());
        return AppointmentResponse.builder()
                .name(person.getName())
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .doseNo(appointment.getDoseNo())
                .doctorName(doctor.getName())
                .vaccineType(vaccineType)
                .centerResponse(centerResponse)
                .build();
    }
}
