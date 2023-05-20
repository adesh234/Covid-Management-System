package com.example.Covid.Vaccination.System.DTO.Response;

import com.example.Covid.Vaccination.System.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PersonResponse {
    String name;
    int age;
    String emailId;
    String mobNo;
    Gender gender;
}
