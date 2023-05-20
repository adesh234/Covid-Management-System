package com.example.Covid.Vaccination.System.Service;

import com.example.Covid.Vaccination.System.DTO.Request.PersonRequest;
import com.example.Covid.Vaccination.System.DTO.Response.PersonResponse;

import java.util.List;

public interface PersonService {
    PersonResponse addPerson(PersonRequest personRequest);

    PersonResponse getByEmail(String emailId);

    PersonResponse updateNameByMobNo(String mobNo,String name);

    List<PersonResponse> getAllPersonDoseNotTaken();

    List<PersonResponse> getAllDose1();

    List<PersonResponse> getAllVaccinated();

    List<PersonResponse> getAllMaleDoseNotTaken();

    List<PersonResponse> getAllFemaleVaccinated();
}
