//package com.qa.VetSurgery.model;
//ATTEMPTING TO USE MANY TO MANY 

//package com.qa.VetSurgery.model;
//
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class InjuryModel {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@NotNull
//	private String injuryType; 
//	
//	@ManyToMany(mappedBy = "PostPetModel")
//	private Set<PostPetModel> postPet; 
//	
//	//public void addInjury(PostPetModel item) {postPet.add(postPet)};
//
//	public Long getId() {return id;}
//
//	public String getInjuryType() {
//		return injuryType;
//	}
//
//	public void setInjuryType(String injuryType) {
//		this.injuryType = injuryType;
//	}
//
//	public Set<PostPetModel> getPostPet() {
//		return postPet;
//	}
//
//	public void setPostPet(Set<PostPetModel> postPet) {
//		this.postPet = postPet;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	
//}
