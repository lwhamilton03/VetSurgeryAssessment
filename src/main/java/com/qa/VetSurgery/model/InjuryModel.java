//package com.qa.VetSurgery.model;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name = "injury")
//public class InjuryModel {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id; 
//	
//	@NotNull
//	private String injuryType; 
//	
//	private String severityRanking;
//
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "petId", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private PetModel pet;
//	
//	public InjuryModel(String injuryType, String severityRanking)
//	{
//		this.injuryType = injuryType;
//		this.severityRanking = severityRanking; 
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getInjuryType() {
//		return injuryType;
//	}
//
//	public void setInjuryType(String injuryType) {
//		this.injuryType = injuryType;
//	}
//
//	public String getSeverityRanking() {
//		return severityRanking;
//	}
//
//	public void setSeverityRanking(String severityRanking) {
//		this.severityRanking = severityRanking;
//	}
//
//	public PetModel getPet() {
//		return pet;
//	}
//
//	public void setPet(PetModel pet) {
//		this.pet = pet;
//	}
//	
//	
//	
//}
