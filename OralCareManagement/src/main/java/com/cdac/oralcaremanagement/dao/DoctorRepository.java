package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

	Doctor findByEmail(String email);

	Doctor findByMobileNo(long mobileNo);

}
