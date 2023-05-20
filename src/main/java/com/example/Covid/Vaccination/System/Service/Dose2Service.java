package com.example.Covid.Vaccination.System.Service;

import com.example.Covid.Vaccination.System.Enum.VaccineType;
import com.example.Covid.Vaccination.System.Model.Dose2;
import com.example.Covid.Vaccination.System.Model.Person;

public interface Dose2Service {
    public Dose2 createDose2(Person person, VaccineType vaccineType);
}
