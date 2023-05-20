package com.example.Covid.Vaccination.System.Repository;

import com.example.Covid.Vaccination.System.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person findByEmailId(String emailId);

    Person findByMobNo(String mobNo);

    @Query(value = "select * from Person p where dose1_status = FALSE and dose2_status = FALSE",nativeQuery = true)
    List<Person> getAllPersonDoseNotTaken();

    @Query(value = "select * from Person p where dose1_status = TRUE and dose2_status = FALSE",nativeQuery = true)
    List<Person> getAlldose1();

    @Query(value = "select * from Person p where dose1_status = TRUE and dose2_status = TRUE",nativeQuery = true)
    List<Person> getAllVaccinated();
}
