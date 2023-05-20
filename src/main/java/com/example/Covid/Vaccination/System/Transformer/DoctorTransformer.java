package com.example.Covid.Vaccination.System.Transformer;

import com.example.Covid.Vaccination.System.DTO.Request.DoctorRequest;
import com.example.Covid.Vaccination.System.DTO.Response.CenterResponse;
import com.example.Covid.Vaccination.System.DTO.Response.DoctorResponse;
import com.example.Covid.Vaccination.System.Model.Doctor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {
    public static Doctor RequestToDoctor(DoctorRequest doctorRequest){
        return Doctor.builder()
                .age(doctorRequest.getAge())
                .mobNo(doctorRequest.getMobNo())
                .name(doctorRequest.getName())
                .emailId(doctorRequest.getEmailId())
                .gender(doctorRequest.getGender())
                .build();
    }
    public static DoctorResponse DoctorToResponse(Doctor doctor){

        CenterResponse centerResponse = CenterTransformer.CenterToResponse(doctor.getVaccinationCenter());
        return DoctorResponse.builder()
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .name(doctor.getName())
                .centerResponse(centerResponse)
                .build();
    }
}
