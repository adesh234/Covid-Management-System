package com.example.Covid.Vaccination.System.Transformer;

import com.example.Covid.Vaccination.System.DTO.Request.CenterRequest;
import com.example.Covid.Vaccination.System.DTO.Response.CenterResponse;
import com.example.Covid.Vaccination.System.Model.VaccinationCenter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CenterTransformer {
    public static VaccinationCenter RequestDtoToCenter(CenterRequest centerRequest){
        VaccinationCenter vaccinationCenter = VaccinationCenter.builder()
                .centerType(centerRequest.getCenterType())
                .name(centerRequest.getName())
                .location(centerRequest.getLocation())
                .build();

        return vaccinationCenter;
    }
    public static CenterResponse CenterToResponse(VaccinationCenter vaccinationCenter){
        CenterResponse centerResponse = CenterResponse.builder()
                .location(vaccinationCenter.getLocation())
                .centerType(vaccinationCenter.getCenterType())
                .name(vaccinationCenter.getName())
                .build();

        return centerResponse;
    }
}
