package com.cdac.oralcaremanagement.service;

import java.util.List;

import com.cdac.oralcaremanagement.entity.User;

public interface IUserService {

	//register User
		User addNewUser(User user);
		 //     (classname object)

		
		//get User
		List<User> getUser();
		
		
		//get specific user
		User getUser(Integer userId);
		
		
		//delete specific user
		String deleteUser(Integer userId);
		
		//update Specific user
		User updateUser(User updatedUser, User existingUser);
	}
