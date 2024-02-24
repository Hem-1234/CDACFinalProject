package com.cdac.oralcaremanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Assessment_table")
public class Assessment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asst_id", nullable = false)
	private long assmntId;

	@OneToOne
	@JoinColumn(name = "pId")
	private Patient pId;

	@ManyToOne
	@JoinColumn(name = "t_id")
	private Treatment tId;

	private String description;

	public Assessment() {
		// TODO Auto-generated constructor stub
	}

	public Assessment(long assmntId, Patient pId, Treatment tId, String description) {
		super();
		this.assmntId = assmntId;
		this.pId = pId;
		this.tId = tId;
		this.description = description;
	}

	public long getAssmntId() {
		return assmntId;
	}

	public void setAssmntId(long assmntId) {
		this.assmntId = assmntId;
	}

	public Patient getpId() {
		return pId;
	}

	public void setpId(Patient pId) {
		this.pId = pId;
	}

	public Treatment gettId() {
		return tId;
	}

	public void settId(Treatment tId) {
		this.tId = tId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Assessment [assmntId=" + assmntId + ", pId=" + pId + ", tId=" + tId + ", description=" + description
				+ "]";
	}

}