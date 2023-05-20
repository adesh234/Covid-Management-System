package com.example.Covid.Vaccination.System.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponse {
    String name;
    String emailId;
    String mobNo;
    CenterResponse centerResponse;

}
