package com.example.Covid.Vaccination.System.DTO.Response;

import com.example.Covid.Vaccination.System.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponse {
    String name;
    String location;
    CenterType centerType;
}
