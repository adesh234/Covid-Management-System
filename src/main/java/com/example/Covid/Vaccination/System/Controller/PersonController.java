package com.example.Covid.Vaccination.System.Controller;

import com.example.Covid.Vaccination.System.DTO.Request.PersonRequest;
import com.example.Covid.Vaccination.System.DTO.Response.PersonResponse;
import com.example.Covid.Vaccination.System.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;
    @PostMapping("/add_person")
    public PersonResponse addPerson(@RequestBody PersonRequest personRequest){
        return personService.addPerson(personRequest);
    }
    @GetMapping("/get_by_email/{emailId}")
    public PersonResponse getByEmail(@PathVariable("emailId")String emailId){
        return personService.getByEmail(emailId);
    }
    @PutMapping("/update_name_by_mobNo/{mobNo}/{name}")
    public PersonResponse updateNameByMobNo(@PathVariable("mobNo")String mobNo,@PathVariable("name")String name){
        return personService.updateNameByMobNo(mobNo,name);
    }
    @GetMapping("/getAll_doseNotTaken")
    public List<PersonResponse> getAllPersonDoseNotTaken(){
        return personService.getAllPersonDoseNotTaken();
    }
    @GetMapping("/all_onlyDose1Taken")
    public List<PersonResponse> getAllDose1(){
        return personService.getAllDose1();
    }
    @GetMapping("/getAll_vaccinated")
    public List<PersonResponse> getAllVaccinated(){
        return personService.getAllVaccinated();
    }
    @GetMapping("getMale_doseNotTaken")
    public List<PersonResponse> getAllMaleDoseNotTaken(){
        return personService.getAllMaleDoseNotTaken();
    }
        @GetMapping("getFemale_vaccinated")
    public List<PersonResponse> getAllFemaleVaccinated(){
        return personService.getAllFemaleVaccinated();
    }
}