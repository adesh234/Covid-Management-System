package com.example.Covid.Vaccination.System.Controller;

import com.example.Covid.Vaccination.System.DTO.Request.CenterRequest;
import com.example.Covid.Vaccination.System.DTO.Response.CenterResponse;
import com.example.Covid.Vaccination.System.Enum.CenterType;
import com.example.Covid.Vaccination.System.Exception.NoCenterException;
import com.example.Covid.Vaccination.System.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccination_center")
public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add_center")
    public CenterResponse addCenter(@RequestBody CenterRequest centerRequest){
        return vaccinationCenterService.addCenter(centerRequest);
    }
    @GetMapping("/get_doctor_atCenter/{id}")
    public ResponseEntity<List<String>> getDoctorsAtCenter(@PathVariable("id") int id) throws NoCenterException {
        try{
            List<String> list = vaccinationCenterService.getDoctorsAtCenter(id);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_centerTypes/{centerType}")
    public List<CenterResponse> getAllCenterOfType(@PathVariable("centerType")CenterType centerType){
        return vaccinationCenterService.getAllCenterOfType(centerType);
    }
}
