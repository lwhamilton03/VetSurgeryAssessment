package com.qa.VetSurgery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.VetSurgery.exception.ResourceNotFoundException;
import com.qa.VetSurgery.model.OwnerModel;
import com.qa.VetSurgery.model.PetModel;
import com.qa.VetSurgery.repository.OwnerRepository;
import com.qa.VetSurgery.repository.PetRepository;



@RestController
@RequestMapping("/api")
public class PetController {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private OwnerRepository myRepository; 
	
	//Posting a pet to a person 
	public PetModel createComment(@PathVariable (value = "ownerId") Long ownerId, @Valid @RequestBody PetModel petModel)
	{
		return petRepository.findById(ownerId)
				.map(OwnerModel -> {petModel.setOwner(OwnerModel);
				return petRepository.save(petModel);})
				.orElseThrow(() -> new ResourceNotFoundException("Owner", "id", petModel));
	}

}
