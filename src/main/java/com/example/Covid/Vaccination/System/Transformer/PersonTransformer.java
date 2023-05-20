package com.example.Covid.Vaccination.System.Transformer;

import com.example.Covid.Vaccination.System.DTO.Request.PersonRequest;
import com.example.Covid.Vaccination.System.DTO.Response.PersonResponse;
import com.example.Covid.Vaccination.System.Model.Person;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonTransformer {
    public static PersonResponse PersonToPersonResponse(Person person){
        PersonResponse personResponse = PersonResponse.builder()
                .age(person.getAge())
                .mobNo(person.getMobNo())
                .name(person.getName())
                .gender(person.getGender())
                .emailId(person.getEmailId())
                .build();

        return personResponse;
    }
    public static Person PersonRequestToPerson(PersonRequest personRequest){
        Person person = Person.builder().age(personRequest.getAge())
                .name(personRequest.getName())
                .emailId(personRequest.getEmailId())
                .mobNo(personRequest.getMobNo())
                .gender(personRequest.getGender())
                .build();

        return person;
    }
}
