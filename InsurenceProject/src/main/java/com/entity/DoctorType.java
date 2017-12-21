package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctorType")
public class DoctorType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String doctorType;
	
	@ManyToOne
	private Doctor doctor;

	public DoctorType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorType(String doctortype) {
		super();
		this.doctorType = doctortype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctortype() {
		return doctorType;
	}

	public void setDoctortype(String doctortype) {
		this.doctorType = doctortype;
	}

	@Override
	public String toString() {
		return "DoctorType [id=" + id + ", doctortype=" + doctorType + "]";
	}

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	

}
