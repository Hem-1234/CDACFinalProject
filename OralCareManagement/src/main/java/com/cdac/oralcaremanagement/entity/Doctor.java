package com.cdac.oralcaremanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor_table")
public class Doctor {

	@Id
	@Column(name = "dId")
	private String dId;

	@Column(name = "firstname")
	private String fName;

	@Column(name = "lastname")
	private String lName;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private long mobileNo;

	@Column
	private String gender;

	@Column
	// private Date dob;
	private LocalDate dob;

	@Column(name = "d_Que")
	private String d_Que;

	@Column(name = "d_Ans")
	private String d_Ans;

	private String address;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(String dId, String fName, String lName, String email, String password, long mobileNo, String gender,
			LocalDate dob, String d_Que, String d_Ans, String address) {
		super();
		this.dId = dId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
		this.d_Que = d_Que;
		this.d_Ans = d_Ans;
		this.address = address;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getD_Que() {
		return d_Que;
	}

	public void setD_Que(String d_Que) {
		this.d_Que = d_Que;
	}

	public String getD_Ans() {
		return d_Ans;
	}

	public void setD_Ans(String d_Ans) {
		this.d_Ans = d_Ans;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", mobileNo=" + mobileNo + ", gender=" + gender + ", dob=" + dob + ", d_Que=" + d_Que
				+ ", d_Ans=" + d_Ans + ", address=" + address + "]";
	}

}
