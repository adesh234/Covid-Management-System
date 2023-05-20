package com.example.Covid.Vaccination.System.Repository;

import com.example.Covid.Vaccination.System.Enum.CenterType;
import com.example.Covid.Vaccination.System.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

    @Query(value = "select * from Vaccination_center v where v.center_type =:centerType",nativeQuery = true)
    List<VaccinationCenter> getAllCenterOfType(String centerType);
}
