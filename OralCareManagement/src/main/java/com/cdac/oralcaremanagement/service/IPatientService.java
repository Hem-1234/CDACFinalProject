package com.cdac.oralcaremanagement.service;

import java.util.List;

import com.cdac.oralcaremanagement.entity.Patient;

public interface IPatientService {

	//register Patient
		Patient addNewPatient(Patient patient);
		 //     (classname object)

		
		//get Patient
		List<Patient> getPatients();
		
		
		//get specific patient
		Patient getPatient(String pId);
		
		
		//delete specific patient
		String deletePatient(String pId);
		
		//update Specific patient
		Patient updatePatient(Patient updatedPatient, Patient existingPatient);
	}
