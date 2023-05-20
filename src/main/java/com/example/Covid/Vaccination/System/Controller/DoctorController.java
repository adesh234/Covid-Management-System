package com.example.Covid.Vaccination.System.Controller;

import com.example.Covid.Vaccination.System.DTO.Request.DoctorRequest;
import com.example.Covid.Vaccination.System.DTO.Response.DoctorResponse;
import com.example.Covid.Vaccination.System.Exception.NoCenterException;
import com.example.Covid.Vaccination.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequest doctorRequest) throws NoCenterException {
        try{
            DoctorResponse doctorResponse = doctorService.addDoctor(doctorRequest);
            return new ResponseEntity(doctorResponse,HttpStatus.CREATED);
        }
        catch (NoCenterException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_more10")
    public List<DoctorResponse> getAllAppointmentMoreThan10(){
        return doctorService.getAllAppointmentMoreThan10();
    }
    @GetMapping("/get_maleAnd40")
    public List<DoctorResponse> getAllMaleMoreThan40(){
        return doctorService.getAllMaleMoreThan40();
    }
    @GetMapping("/get_ratio")
    public String getRatioMaleToFemale(){
        return doctorService.getRatioMaleToFemale();
    }
}
