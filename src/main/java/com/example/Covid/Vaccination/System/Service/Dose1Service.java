package com.example.Covid.Vaccination.System.Service;

import com.example.Covid.Vaccination.System.Enum.VaccineType;
import com.example.Covid.Vaccination.System.Model.Dose1;
import com.example.Covid.Vaccination.System.Model.Person;

public interface Dose1Service {
    public Dose1 createDose1(Person person, VaccineType vaccineType);
}
