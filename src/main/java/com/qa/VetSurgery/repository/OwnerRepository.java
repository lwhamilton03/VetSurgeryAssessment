package com.qa.VetSurgery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.VetSurgery.model.OwnerModel;




@Repository
public interface OwnerRepository extends JpaRepository<OwnerModel, Long>{

	public OwnerModel findByName(String name); 
	
	public OwnerModel findByAddress(String address); 
	
	public OwnerModel findByContactNum(String contactNum);
}
