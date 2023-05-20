package com.example.Covid.Vaccination.System.DTO.Request;

import com.example.Covid.Vaccination.System.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorRequest {
    String name;
    int age;
    String emailId;
    String mobNo;
    Gender gender;
    int centerId;
}
