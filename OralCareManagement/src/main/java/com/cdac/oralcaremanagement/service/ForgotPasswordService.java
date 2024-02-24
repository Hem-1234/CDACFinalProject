package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.PatientRepository;
import com.cdac.oralcaremanagement.entity.Patient;

@Service
public class ForgotPasswordService {

   @Autowired
   private PatientRepository patientRepository;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   public String resetPassword(Patient patient) {
	   Patient dbUser = patientRepository.findByEmail(patient.getEmail());
	   String ans = dbUser.getAns();
	   if(dbUser != null) {
		   if(patient.getAns().equals(ans)) {
			   dbUser.setPassword(passwordEncoder.encode(patient.getPassword()));
			   return "Password changed Successfully ";
		   }
		   return "wrong ans";
	   } else
		return "email not found";
   }
}
