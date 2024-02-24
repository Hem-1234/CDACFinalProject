package com.cdac.oralcaremanagement.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.oralcaremanagement.dto.ErrorResponse;
import com.cdac.oralcaremanagement.entity.Patient;
import com.cdac.oralcaremanagement.service.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {

	@Autowired
	private PatientService patientServiceRef;

	// http://localhost:8000/patient/addPatient
	// @PostMapping("/addPatient")
//	public void addNewPatient(@RequestBody Patient patientRef) {
//		System.out.println(patientRef);
//		patientServiceRef.addNewPatient(patientRef);
//	}

	@PostMapping("/addPatient")
	public ResponseEntity<?> AddPatient(@RequestBody Patient transientPatient) {
		try {
			String patient = patientServiceRef.addNewPatient(transientPatient);
			return new ResponseEntity<>(patient, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Failed to add user", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8000/patient/getPatients
	@GetMapping("/getPatients")
	public Collection<Patient> getAllPatients() {

		Collection<Patient> allPatients = patientServiceRef.getAllPatients();
		return allPatients;
	}

	// http://localhost:8000/patient/getPatient/P1003
	@GetMapping("/getPatient/{pId}")
	public Patient getOneUser(@PathVariable("pId") String pId) {
		Patient foundPatient = patientServiceRef.getOnePatient(pId);
		return foundPatient;
	}

	// http://localhost:8000/patient/updatePatient/P1005

//@PutMapping("/updatePatient/{pId}") // to update existing patient
//	public Patient updateById(@RequestBody Patient updatedPatient, @PathVariable String pId) {
//		Patient existingPatient = patientServiceRef.getOnePatient(pId);
//		return patientServiceRef.updatedPatient(existingPatient, updatedPatient);
//	}

	// http://localhost:8000/updatePatient/P1003
	@PutMapping("/updatePatient/{pId}")
	public ResponseEntity<?> updateById(@RequestBody Patient updatedPatient, @PathVariable String pId) {
		Patient existingPatient = patientServiceRef.getOnePatient(pId);
		if (existingPatient == null) {
			return ResponseEntity.notFound().build(); // Return 404 Not Found if patient doesn't exist
		}
		// Update the existing patient and return a response
		return ResponseEntity.ok(patientServiceRef.updatedPatient(existingPatient, updatedPatient));
	}

	// http://localhost:8000/getPatient/pId
	@DeleteMapping("/deletePatient/patient/{pId}")
	public void deleteOnePatient(@PathVariable("pId") String pId) {

		patientServiceRef.deleteOnePatient(pId);
	}

}
