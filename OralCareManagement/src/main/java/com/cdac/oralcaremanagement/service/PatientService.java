package com.cdac.oralcaremanagement.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.PatientRepository;
import com.cdac.oralcaremanagement.entity.Counters;
import com.cdac.oralcaremanagement.entity.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private PatientRepository patientRepoRef;

	@Autowired
	private PasswordEncoder encoder;

	public String addNewPatient(Patient patientRef) {

		Patient email = patientRepoRef.findByEmail(patientRef.getEmail());
		Patient mobileNo = patientRepoRef.findByMobileNo(patientRef.getMobileNo());

		if (email != null) {
			return "Email address already exist";
		} else if (mobileNo != null) {
			return "Mobile Number already exist";
		} else {
			Counters counterPatientId = entityManager.find(Counters.class, "patient");
			String patientId = counterPatientId.getIntitialValue() + counterPatientId.nextValue();
			patientRef.setpId(patientId);

			patientRef.setPassword(encoder.encode(patientRef.getPassword()));

			// Save the user to the database
			patientRepoRef.save(patientRef);

			return "Registration successfully Completed";
		}

	}

	public Collection<Patient> getAllPatients() {

		Collection<Patient> getAllPatients = patientRepoRef.findAll();
		return getAllPatients;
	}

	public Patient getOnePatient(String pId) {
		// Optional class is provided since Java 8.
		// Its object may hold a value or may not.
		Patient foundPatient = null;
		Optional<Patient> opt = patientRepoRef.findById(pId);
		if (!opt.isEmpty())
			foundPatient = opt.get();// Getting the Patient object from that Optional object
		return foundPatient;

//		return patientRepoRef.findById(id).orElseThrow(() -> new PatientHandlingException("Invalid Patient id!!"));
	}

	public Patient updatedPatient(Patient existingPatient, Patient updatedPatient) {
		
		existingPatient.setfName(updatedPatient.getfName());
		existingPatient.setlName(updatedPatient.getlName());
		existingPatient.setQue(updatedPatient.getQue());
		existingPatient.setAns(updatedPatient.getAns());
		existingPatient.setDob(updatedPatient.getDob());
		existingPatient.setAddress(updatedPatient.getAddress());

		return patientRepoRef.save(existingPatient);
	}

	public void deleteOnePatient(String pId) {
		patientRepoRef.deleteById(pId);
	}

}
