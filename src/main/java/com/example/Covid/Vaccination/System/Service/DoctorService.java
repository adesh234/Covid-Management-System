package com.example.Covid.Vaccination.System.Service;


import com.example.Covid.Vaccination.System.DTO.Request.DoctorRequest;
import com.example.Covid.Vaccination.System.DTO.Response.DoctorResponse;
import com.example.Covid.Vaccination.System.Exception.NoCenterException;

import java.util.List;

public interface DoctorService {
    DoctorResponse addDoctor(DoctorRequest doctorRequest) throws NoCenterException;

    List<DoctorResponse> getAllAppointmentMoreThan10();

    List<DoctorResponse> getAllMaleMoreThan40();

    String getRatioMaleToFemale();
}
