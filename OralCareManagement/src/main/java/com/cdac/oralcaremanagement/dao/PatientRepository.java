package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{
	
    Patient findByEmail(String email);

	Patient findByMobileNo(long mobileNo);


}
