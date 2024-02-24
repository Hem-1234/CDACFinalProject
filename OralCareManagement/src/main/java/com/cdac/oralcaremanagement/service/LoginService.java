package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.UserRepository;
import com.cdac.oralcaremanagement.entity.User;

@Service
public class LoginService {

	@Autowired
	private UserRepository patientRepo;

	public boolean authenticate(String email, String password) {
		User user = patientRepo.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return true; // Authentication successful
		}
		return false; // Authentication failed
	}
}