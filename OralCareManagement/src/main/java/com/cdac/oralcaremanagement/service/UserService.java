package com.cdac.oralcaremanagement.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.IUserRepository;
import com.cdac.oralcaremanagement.entity.User;


@Service
public class UserService {

	@Autowired
	private IUserRepository userRepoRef;

	@Autowired
	private PasswordEncoder encoder;

	public String addNewUser(User userRef) {

		User email = userRepoRef.findByEmail(userRef.getEmail());
		User mobileNo = userRepoRef.findByMobileNo(userRef.getMobileNo());

		if (email != null) {
			return "Email address already exist";
		} else if (mobileNo != null) {
			return "Mobile Number already exist";
		}
		userRef.setPassword(encoder.encode(userRef.getPassword()));

		// Save the user to the database
		userRepoRef.save(userRef);

		return "Registration successfully completed";
	}

	public Collection<User> getAllUsers() {

		Collection<User> getAllUsers = userRepoRef.findAll();
		return getAllUsers;
	}

	public User getOneUser(Integer uId) {
		// Optional class is provided since Java 8.
		// Its object may hold a value or may not.
		User foundUser = null;
		Optional<User> opt = userRepoRef.findById(uId);
		if (!opt.isEmpty())
			foundUser = opt.get();// Getting the User object from that Optional object
		return foundUser;

//		return userRepoRef.findById(id).orElseThrow(() -> new USeHandlingException("Invalid User id!!"));
	}

	public User updatedUser(User existingUser, User updatedUser) {

		existingUser.setfName(updatedUser.getfName());
		existingUser.setlName(updatedUser.getlName());
		existingUser.setQue(updatedUser.getQue());
		existingUser.setAns(updatedUser.getAns());
		existingUser.setDob(updatedUser.getDob());
		existingUser.setAddress(updatedUser.getAddress());

		return userRepoRef.save(existingUser);
	}

	public void deleteOnePatient(Integer uId) {
		userRepoRef.deleteById(uId);
	}

}
