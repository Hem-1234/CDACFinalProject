package com.cdac.oralcaremanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment_table")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appt_id", nullable = false)
	private Long apptId;

	private String bldgrp;
	private String reason;
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "p_id", nullable = false)
	private Patient pId;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long apptId, String bldgrp, String reason, LocalDate date, Patient pId) {
		super();
		this.apptId = apptId;
		this.bldgrp = bldgrp;
		this.reason = reason;
		this.date = date;
		this.pId = pId;
	}

	public Long getApptId() {
		return apptId;
	}

	public void setApptId(Long apptId) {
		this.apptId = apptId;
	}

	public String getBldgrp() {
		return bldgrp;
	}

	public void setBldgrp(String bldgrp) {
		this.bldgrp = bldgrp;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Patient getpId() {
		return pId;
	}

	public void setpId(Patient pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "Appointment [apptId=" + apptId + ", bldgrp=" + bldgrp + ", reason=" + reason + ", date=" + date
				+ ", pId=" + pId + "]";
	}

}
