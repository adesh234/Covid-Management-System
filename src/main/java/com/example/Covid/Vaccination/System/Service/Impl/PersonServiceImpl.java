package com.example.Covid.Vaccination.System.Service.Impl;

import com.example.Covid.Vaccination.System.DTO.Request.PersonRequest;
import com.example.Covid.Vaccination.System.DTO.Response.PersonResponse;
import com.example.Covid.Vaccination.System.Enum.Gender;
import com.example.Covid.Vaccination.System.Model.Person;
import com.example.Covid.Vaccination.System.Repository.PersonRepository;
import com.example.Covid.Vaccination.System.Service.PersonService;
import com.example.Covid.Vaccination.System.Transformer.PersonTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonResponse addPerson(PersonRequest personRequest) {
        Person person = PersonTransformer.PersonRequestToPerson(personRequest);

        person.setDose2Status(false);
        person.setDose1Status(false);

        Person person1 = personRepository.save(person);
        PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person1);

        return personResponse;
    }

    @Override
    public PersonResponse getByEmail(String emailId) {
        Person person = personRepository.findByEmailId(emailId);
        PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person);
        return personResponse;
    }

    @Override
    public PersonResponse updateNameByMobNo(String mobNo,String name) {
        Person person = personRepository.findByMobNo(mobNo);
        person.setName(name);
        Person person1 = personRepository.save(person);
        PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person1);
        return personResponse;
    }

    @Override
    public List<PersonResponse> getAllPersonDoseNotTaken() {
        List<Person> personList = personRepository.getAllPersonDoseNotTaken();
        List<PersonResponse> personResponses = new ArrayList<>();
        for(Person person:personList){
            PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person);
            personResponses.add(personResponse);
        }
        return personResponses;
    }

    @Override
    public List<PersonResponse> getAllDose1() {
        List<Person> personList = personRepository.getAlldose1();
        List<PersonResponse> personResponses = new ArrayList<>();
        for(Person person:personList){
            PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person);
            personResponses.add(personResponse);
        }
        return personResponses;
    }

    @Override
    public List<PersonResponse> getAllVaccinated() {
        List<Person> personList = personRepository.getAllVaccinated();
        List<PersonResponse> personResponses = new ArrayList<>();
        for(Person person:personList){
            PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person);
            personResponses.add(personResponse);
        }
        return personResponses;
    }

    @Override
    public List<PersonResponse> getAllMaleDoseNotTaken() {
        List<Person> personList = personRepository.getAllPersonDoseNotTaken();
        List<PersonResponse> personResponses = new ArrayList<>();
        for(Person person:personList){
            if(person.getGender().equals(Gender.MALE)){
                PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person);
                personResponses.add(personResponse);
            }
        }
        return personResponses;
    }

    @Override
    public List<PersonResponse> getAllFemaleVaccinated() {
        List<Person> personList = personRepository.getAllVaccinated();
        List<PersonResponse> personResponses = new ArrayList<>();
        for(Person person:personList){
            if(person.getGender().equals(Gender.FEMALE)){
                PersonResponse personResponse = PersonTransformer.PersonToPersonResponse(person);
                personResponses.add(personResponse);
            }
        }
        return personResponses;
    }
}