package com.example.Covid.Vaccination.System.Service.Impl;

import com.example.Covid.Vaccination.System.Enum.VaccineType;
import com.example.Covid.Vaccination.System.Model.Dose1;
import com.example.Covid.Vaccination.System.Model.Person;
import com.example.Covid.Vaccination.System.Service.Dose1Service;
import com.example.Covid.Vaccination.System.Transformer.Dose1Transformer;
import org.springframework.stereotype.Service;

@Service
public class Dose1ServiceImpl implements Dose1Service {
    @Override
    public Dose1 createDose1(Person person, VaccineType vaccineType) {
        Dose1 dose1 = Dose1Transformer.ToDose1(person,vaccineType);
        return dose1;
    }
}
