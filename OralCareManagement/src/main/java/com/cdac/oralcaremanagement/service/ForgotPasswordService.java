package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.IUserRepository;
import com.cdac.oralcaremanagement.entity.User;

@Service
public class ForgotPasswordService {

   @Autowired
   private IUserRepository iUserRepository;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   public String resetPassword(User user) {
	   User dbUser = iUserRepository.findByEmail(user.getEmail());
	   String ans = dbUser.getAns();
	   if(dbUser != null) {
		   if(user.getAns().equals(ans)) {
			   dbUser.setPassword(passwordEncoder.encode(user.getPassword()));
			   return "Password changed Successfully ";
		   }
		   return "wrong ans";
	   } else
		return "email not found";
   }
}
