package com.example.Covid.Vaccination.System.Repository;

import com.example.Covid.Vaccination.System.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
