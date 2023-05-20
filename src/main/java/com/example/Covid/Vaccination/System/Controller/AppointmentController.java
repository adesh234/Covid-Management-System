package com.example.Covid.Vaccination.System.Controller;

import com.example.Covid.Vaccination.System.DTO.Request.AppointmentRequest;
import com.example.Covid.Vaccination.System.DTO.Response.AppointmentResponse;
import com.example.Covid.Vaccination.System.Exception.NoDoctorException;
import com.example.Covid.Vaccination.System.Exception.NoPersonException;
import com.example.Covid.Vaccination.System.Exception.NotEligibleForDoseException;
import com.example.Covid.Vaccination.System.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity addAppointment(@RequestBody AppointmentRequest appointmentRequest) throws NoDoctorException, NoPersonException, NotEligibleForDoseException {
        try{
            AppointmentResponse appointmentResponse = appointmentService.addAppointment(appointmentRequest);
            return new ResponseEntity(appointmentResponse,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
