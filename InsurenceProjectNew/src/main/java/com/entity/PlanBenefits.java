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
import javax.persistence.Table;


@Entity
@Table(name="planBenefits")
public class PlanBenefits implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="planBenefit_ID")
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Double amountCovered;
	
	@ManyToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinTable(name = "Plan_Benefits", joinColumns = { @JoinColumn (name = "planBenefit_ID") }, inverseJoinColumns = { @JoinColumn (name = "InsurancePlan_ID") })
	private List<InsurancePlan> insurancePlan;

	public PlanBenefits(int id, String name, String description, Double amountCovered, List<InsurancePlan> insurancePlan) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amountCovered = amountCovered;
		this.insurancePlan = insurancePlan;
	}

	public PlanBenefits() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmountCovered() {
		return amountCovered;
	}

	public void setAmountCovered(double amountCovered) {
		this.amountCovered = amountCovered;
	}

	public List<InsurancePlan> getPlan() {
		return insurancePlan;
	}

	public void setPlan(List<InsurancePlan> insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	@Override
	public String toString() {
		return "PlanBenefits [id=" + id + ", name=" + name + ", description=" + description + ", amountCovered="
				+ amountCovered + ", insurancePlan=" + insurancePlan + "]";
	}
	
}
