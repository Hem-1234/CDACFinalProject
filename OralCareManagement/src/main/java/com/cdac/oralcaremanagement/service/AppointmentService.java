package com.cdac.oralcaremanagement.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.IAppointmentRepository;
import com.cdac.oralcaremanagement.entity.Appointment;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.IAppointmentRepository;
import com.cdac.oralcaremanagement.entity.Appointment;

@Service
public class AppointmentService {

	@Autowired
	private IAppointmentRepository apptRepoRef;

	public Appointment addNewAppt(Appointment apptRef) {
		return apptRepoRef.save(apptRef);

	}

	public Collection<Appointment> getAllAppts() {
		Collection<Appointment> allAppts = apptRepoRef.findAll();
		return allAppts;
	}

//	public Appointment getOneAppt(Long apptId) {
//		
//		Appointment foundAppt = null;
//		Optional<Appointment> opt = apptRepoRef.findById(apptId);
//		if (!opt.isEmpty())
//			foundAppt = opt.get();// Getting the Appointment object from that Optional object
//		return foundAppt;
//	}
	

    public Collection<Appointment> getAppointmentsByDate(LocalDate date) {
        return apptRepoRef.findByDate(date);
    }
	
	public Appointment updateAppt(Appointment existingAppt , Appointment updatedAppt) {
		existingAppt.setBldgrp(updatedAppt.getBldgrp());
		existingAppt.setDate(updatedAppt.getDate());
		return apptRepoRef.save(existingAppt);
	}
	
	
	public void deleteOneAppt(Long apptId) {
		apptRepoRef.deleteById(apptId);
	}	
}