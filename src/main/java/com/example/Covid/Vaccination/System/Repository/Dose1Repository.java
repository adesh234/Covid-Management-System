package com.example.Covid.Vaccination.System.Repository;

import com.example.Covid.Vaccination.System.Model.Dose1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dose1Repository extends JpaRepository<Dose1,Integer> {
}
