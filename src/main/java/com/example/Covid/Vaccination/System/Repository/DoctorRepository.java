package com.example.Covid.Vaccination.System.Repository;

import com.example.Covid.Vaccination.System.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query(value = "select * from Doctor d where d.gender = 'MALE' and d.age > 40",nativeQuery = true)
    List<Doctor> getAllMaleMoreThan40();
}
