package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	private String country;
	private String city;
	private String street;
	private String apt;
	//private int doctors_id;

	@ManyToOne
	private Doctor doctor;

	public Location(int id, String country, String city, String street, String apt) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.apt = apt;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(String country, String city, String street, String apt, Doctor doctor) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.apt = apt;
		this.doctor = doctor;
	}

	/*@Override
	public String toString() {
		return "Location [id=" + id + ", country=" + country + ", city=" + city + ", street=" + street + ", apt=" + apt
				+ ", doctor=" + doctor + "]";
	}
*/
	/*public int getDoctor_id() {
		return doctors_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctors_id = doctor_id;
	}*/

	
}
