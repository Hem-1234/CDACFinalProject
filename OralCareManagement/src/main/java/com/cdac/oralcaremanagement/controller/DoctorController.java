package com.cdac.oralcaremanagement.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.oralcaremanagement.entity.Doctor;
import com.cdac.oralcaremanagement.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("*")
public class DoctorController {

	@Autowired
	private DoctorService doctorServiceRef;

	// http://localhost:8000/doctor/addDoctor
	@PostMapping("/addDoctor")
	public void addNewDoctor(@RequestBody Doctor doctorRef) {
		System.out.println(doctorRef);
		doctorServiceRef.addNewDoctor(doctorRef);
	}

	// http://localhost:8000/doctor/getDoctors
	@GetMapping("/getDoctors")
	public Collection<Doctor> getAllDoctors() {

		Collection<Doctor> allDoctors = doctorServiceRef.getAllDoctors();
		return allDoctors;
	}

	// http://localhost:8000/doctor/getDoctor/D102
	@GetMapping("/getDoctor/{dId}")
	public Doctor getOneDoctor(@PathVariable("dId") String dId) {
		Doctor foundDoctor = doctorServiceRef.getOneDoctor(dId);
		return foundDoctor;
	}

	// http://localhost:8000/doctor/updateDoctor/D103
	@PutMapping("/updateDoctor/{dId}") // to update existing patient
	public Doctor updateById(@RequestBody Doctor updatedDoctor, @PathVariable String dId) {
		Doctor existingDoctor = doctorServiceRef.getOneDoctor(dId);
		return doctorServiceRef.updatedDoctor(existingDoctor, updatedDoctor);
	}

	// http://localhost:8000/doctor/deleteDoctor/dId
	@DeleteMapping("/deleteDoctor/{dId}")
	public void deleteOneDoctor(@PathVariable("dId") String dId) {

		doctorServiceRef.deleteOneDoctor(dId);
	}

}
