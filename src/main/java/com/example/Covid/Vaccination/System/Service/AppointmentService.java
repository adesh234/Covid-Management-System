package com.example.Covid.Vaccination.System.Service;

import com.example.Covid.Vaccination.System.DTO.Request.AppointmentRequest;
import com.example.Covid.Vaccination.System.DTO.Response.AppointmentResponse;
import com.example.Covid.Vaccination.System.Exception.NoDoctorException;
import com.example.Covid.Vaccination.System.Exception.NoPersonException;
import com.example.Covid.Vaccination.System.Exception.NotEligibleForDoseException;

public interface AppointmentService {
    AppointmentResponse addAppointment(AppointmentRequest appointmentRequest) throws NoPersonException, NoDoctorException, NotEligibleForDoseException;
}
