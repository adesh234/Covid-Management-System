package com.example.Covid.Vaccination.System.Service.Impl;

import com.example.Covid.Vaccination.System.Enum.VaccineType;
import com.example.Covid.Vaccination.System.Model.Dose2;
import com.example.Covid.Vaccination.System.Model.Person;
import com.example.Covid.Vaccination.System.Service.Dose2Service;
import com.example.Covid.Vaccination.System.Transformer.Dose2Transformer;
import org.springframework.stereotype.Service;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Override
    public Dose2 createDose2(Person person, VaccineType vaccineType) {
        return Dose2Transformer.ToDose2(person,vaccineType);
    }
}
