package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.PatientRepository;
import com.cdac.oralcaremanagement.entity.Patient;

@Service
public class LoginService {

	@Autowired
	private PatientRepository patientRepo;

	public boolean authenticate(String email, String password) {
		Patient patient = patientRepo.findByEmail(email);
		if (patient != null && patient.getPassword().equals(password)) {
			return true; // Authentication successful
		}
		return false; // Authentication failed
	}
}