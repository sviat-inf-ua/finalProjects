package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//table doctortype
	@OneToMany(fetch=FetchType.LAZY,mappedBy="doctor")
	private List<DoctorType> doctorTypes;

	//table location
	@OneToMany(fetch=FetchType.EAGER,mappedBy="doctor")
	private List<Location> locations;
	
	private String firstName;
	private String lastName;
	private long cellPhone;
	private String email;
	private String password;
	private String passwordCommit;
	private int active;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<DoctorType> getDoctorTypes() {
		return doctorTypes;
	}
	public void setDoctorTypes(List<DoctorType> doctorTypes) {
		this.doctorTypes = doctorTypes;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(long cellPhone) {
		this.cellPhone = cellPhone;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
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
	public String getPasswordCommit() {
		return passwordCommit;
	}
	public void setPasswordCommit(String passwordCommit) {
		this.passwordCommit = passwordCommit;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorTypes=" + doctorTypes + ", locations=" + locations + ", firstName="
				+ firstName + ", lastName=" + lastName + ", cellPhone=" + cellPhone + ", email=" + email + ", password="
				+ password + ", passwordCommit=" + passwordCommit + ", active=" + active + "]";
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int id, List<DoctorType> doctorTypes, List<Location> locations, String firstName, String lastName,
			long cellPhone, String email, String password, String passwordCommit, int active) {
		super();
		this.id = id;
		this.doctorTypes = doctorTypes;
		this.locations = locations;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellPhone = cellPhone;
		this.email = email;
		this.password = password;
		this.passwordCommit = passwordCommit;
		this.active = active;
	}
	
}
