package com.example.Covid.Vaccination.System.Service;

import com.example.Covid.Vaccination.System.DTO.Request.CenterRequest;
import com.example.Covid.Vaccination.System.DTO.Response.CenterResponse;
import com.example.Covid.Vaccination.System.Enum.CenterType;
import com.example.Covid.Vaccination.System.Exception.NoCenterException;

import java.util.List;

public interface VaccinationCenterService {
    CenterResponse addCenter(CenterRequest centerRequest);

    List<String> getDoctorsAtCenter(int id) throws NoCenterException;

    List<CenterResponse> getAllCenterOfType(CenterType centerType);
}
