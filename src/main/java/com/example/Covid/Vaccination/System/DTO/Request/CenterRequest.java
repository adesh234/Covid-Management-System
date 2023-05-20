package com.example.Covid.Vaccination.System.DTO.Request;

import com.example.Covid.Vaccination.System.Enum.CenterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterRequest {
    String name;
    String location;
    CenterType centerType;
}
