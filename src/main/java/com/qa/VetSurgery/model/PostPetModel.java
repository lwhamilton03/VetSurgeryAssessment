//ATTEMPTING TO UNDERSTAND THE MANY TO MANY 

//package com.qa.VetSurgery.model;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.Lob;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//
//@Entity
//@Table(name = "pet")
//public class PostPetModel {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id; 
//	
//	@NotNull
//	private String name; 
//	
//	@NotNull
//	@Lob
//	private String medicalHistory; 
//	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
////	@JoinTable
////	private Set<InjuryModel> injury; 
//	@JoinColumn(name = "owner_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private OwnerModel owner; 
//	
//	public PostPetModel(String name, String medicalHistory)
//	{
//		this.name = name; 
//		this.medicalHistory = medicalHistory; 
//	}
//	
//	public PostPetModel()
//	{
//		
//	}
//	
//	
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getMedicalHistory() {
//		return medicalHistory;
//	}
//
//	public void setMedicalHistory(String medicalHistory) {
//		this.medicalHistory = medicalHistory;
//	}
//
//	public OwnerModel getOwner() {
//		return owner;
//	}
//
//	public void setOwner(OwnerModel owner) {
//		this.owner = owner;
//	}
//
//}