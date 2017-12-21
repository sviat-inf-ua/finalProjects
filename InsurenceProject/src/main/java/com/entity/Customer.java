package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column
	@NotBlank (message="Email can not be null")
	private String email;
	
	
	@Column
	@NotBlank (message="First name can not be null")
	private String fname; 
//	@NotBlank (message="First name can not be null")
	@Column
	@NotBlank (message="Last Name can not be null")
	private String lname;
//	@NotBlank (message="Last Name can not be null")
	@Column
	private String mname;
	@Column
	@NotBlank (message="Date of birth can not be null")
	private String dob;
//	@NotBlank (message="Date of birth can not be null")
	@Column
	@NotNull (message="Social Security Number can not be null")
	private String phone;
//	@NotBlank (message="Phone number can not be null")
	@Column
	@NotNull (message="Social Security Number can not be null")
	private Integer ssn;
//	@NotBlank (message="Social Security Number can not be null")
	@Column
	@NotBlank (message="Password can not be null")
	@Size (min=8, max=20, message="Password must contain between 8 and 20 characters")
	private String pswd;
//		
	@Column
	private boolean status;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public Customer() {
		super();
	}
	public Customer(String email, String fname, String lname, String mname, String dob, String phone, Integer ssn,
			String pswd, boolean status) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.mname = mname;
		this.dob = dob;
		this.phone = phone;
		this.ssn = ssn;
		this.pswd = pswd;
		this.status = status;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Customer(long id, String email, String fname, String lname, String mname, String dob, String phone, Integer ssn,
			String pswd, boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.mname = mname;
		this.dob = dob;
		this.phone = phone;
		this.ssn = ssn;
		this.pswd = pswd;
		this.status = status;
	}
	
}
