package com.example.Covid.Vaccination.System.DTO.Request;

import com.example.Covid.Vaccination.System.Enum.DoseNo;
import com.example.Covid.Vaccination.System.Enum.VaccineType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequest {
    DoseNo doseNo;
    int personId;
    int doctorId;
    VaccineType vaccineType;
}
