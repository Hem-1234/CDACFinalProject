package com.cdac.oralcaremanagement.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long>{

	  List<Appointment> findByDate(LocalDate date);
}
