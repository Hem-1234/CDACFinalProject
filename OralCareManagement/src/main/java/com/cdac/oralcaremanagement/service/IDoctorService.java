package com.cdac.oralcaremanagement.service;

import java.util.List;

import com.cdac.oralcaremanagement.entity.Doctor;

public interface IDoctorService {

	//register Doctor
			Doctor addNewDoctor(Doctor doctor);
			 //     (classname object)

			
			//get Doctor
			List<Doctor> getDoctors();
			
			
			//get specific doctor
			Doctor getDoctor(String dId);
			
			
			//delete specific doctor
			String deleteDoctor(String dId);
			
			//update Specific doctor
			Doctor updateDoctor(Doctor updatedDoctor, Doctor existingDoctot);
		}

