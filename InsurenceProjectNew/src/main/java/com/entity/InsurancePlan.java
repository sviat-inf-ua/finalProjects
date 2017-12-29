package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="InsurancePlan")
public class InsurancePlan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="insurancePlan_id")
	private int id;
	@Column
	private String name;
	@Column
	private Double price;
	@Column
	private Double amountCovered;
	
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Plan_Benefits", joinColumns = { @JoinColumn (name = "InsurancePlan_ID") }, inverseJoinColumns = { @JoinColumn (name = "planBenefit_ID") })
	private List<PlanBenefits> planBenefits;
	
	public List<PlanBenefits> getPlanBenefits() {
		return planBenefits;
	}
	public void setPlanBenefits(List<PlanBenefits> planBenefits) {
		this.planBenefits = planBenefits;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAmountCovered() {
		return amountCovered;
	}
	public void setAmountCovered(Double amountCovered) {
		this.amountCovered = amountCovered;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	@Column
	@OneToMany(mappedBy = "plan")
	private List<Customer> customer;
	public InsurancePlan(int id, String name, Double price, Double amountCovered, List<Customer> customer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.amountCovered = amountCovered;
		this.customer = customer;
	}
	public InsurancePlan() {
		super();
	}
	
	
}
