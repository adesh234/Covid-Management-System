package com.example.Covid.Vaccination.System.Transformer;

import com.example.Covid.Vaccination.System.Enum.VaccineType;
import com.example.Covid.Vaccination.System.Model.Dose1;
import com.example.Covid.Vaccination.System.Model.Person;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.CreationTimestamp;

import java.util.UUID;

@UtilityClass
public class Dose1Transformer {
    public static Dose1 ToDose1(Person person, VaccineType vaccineType){
        return Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .person(person)
                .build();
    }
}
