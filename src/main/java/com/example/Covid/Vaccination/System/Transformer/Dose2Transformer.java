package com.example.Covid.Vaccination.System.Transformer;

import com.example.Covid.Vaccination.System.Enum.VaccineType;
import com.example.Covid.Vaccination.System.Model.Dose2;
import com.example.Covid.Vaccination.System.Model.Person;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Dose2Transformer {
    public Dose2 ToDose2(Person person, VaccineType vaccineType){
        return Dose2.builder()
                .vaccineType(vaccineType)
                .doseId(String.valueOf(UUID.randomUUID()))
                .person(person)
                .build();
    }
}
