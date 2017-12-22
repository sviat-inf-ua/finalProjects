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
@Table
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
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorTypes=" + doctorTypes + ", locations=" + locations + ", firstName="
				+ firstName + ", lastName=" + lastName + ", cellPhone=" + cellPhone + ", active=" + active + "]";
	}
	public Doctor(List<DoctorType> doctorTypes, List<Location> locations, String firstName, String lastName,
			int cellPhone, int active) {
		super();
		this.doctorTypes = doctorTypes;
		this.locations = locations;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellPhone = cellPhone;
		this.active = active;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
