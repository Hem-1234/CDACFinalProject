package com.cdac.oralcaremanagement.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.DoctorRepository;
import com.cdac.oralcaremanagement.entity.Counters;
import com.cdac.oralcaremanagement.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DoctorService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private DoctorRepository doctorRepoRef;
	

	@Autowired
	private PasswordEncoder encoder;

	public String addNewDoctor(Doctor doctorRef) {

		Doctor email = doctorRepoRef.findByEmail(doctorRef.getEmail());
		Doctor mobileNo = doctorRepoRef.findByMobileNo(doctorRef.getMobileNo());

		if (email != null) {
			return "Email address already exist";
		} else if (mobileNo != null) {
			return "Mobile Number already exist";
		} else {
			Counters counterDoctorId = entityManager.find(Counters.class, "doctor");
			
			String doctorId = counterDoctorId.getIntitialValue() + counterDoctorId.nextValue();
			doctorRef.setdId(doctorId);

			doctorRef.setPassword(encoder.encode(doctorRef.getPassword()));

			// Save the user to the database
			doctorRepoRef.save(doctorRef);

			return "Registration successfully Completed";
		}

	}

	public Collection<Doctor> getAllDoctors() {

		Collection<Doctor> getAllDoctors = doctorRepoRef.findAll();
		return getAllDoctors;
	}

	public Doctor getOneDoctor(String dId) {
		// Optional class is provided since Java 8.
		// Its object may hold a value or may not.
		Doctor foundDoctor = null;
		Optional<Doctor> opt = doctorRepoRef.findById(dId);
		if (!opt.isEmpty())
			foundDoctor = opt.get();// Getting the Doctor object from that Optional object
		return foundDoctor;

//		return doctorRepoRef.findById(dId).orElseThrow(() -> new PatientHandlingException("Invalid Patient id!!"));
	}

	public Doctor updatedDoctor(Doctor existingDoctor, Doctor updatedDoctor) {
		
		existingDoctor.setfName(updatedDoctor.getfName());
		existingDoctor.setlName(updatedDoctor.getlName());		
		existingDoctor.setD_Que(updatedDoctor.getD_Que());
		existingDoctor.setD_Ans(updatedDoctor.getD_Ans());
		existingDoctor.setDob(updatedDoctor.getDob());
		existingDoctor.setAddress(updatedDoctor.getAddress());

		return doctorRepoRef.save(existingDoctor);
	}

	public void deleteOneDoctor(String dId) {
		doctorRepoRef.deleteById(dId);
	}

}