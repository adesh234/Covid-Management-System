package com.example.Covid.Vaccination.System.DTO.Response;

import com.example.Covid.Vaccination.System.Enum.DoseNo;
import com.example.Covid.Vaccination.System.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponse {
    String appointmentNo;
    String name;
    Date dateOfAppointment;

    DoseNo doseNo;
    CenterResponse centerResponse;
    String doctorName;
    VaccineType vaccineType;
}