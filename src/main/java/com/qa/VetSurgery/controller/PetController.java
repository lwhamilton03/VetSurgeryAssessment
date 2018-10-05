package com.qa.VetSurgery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//Posting a pet to a owner 
	@PostMapping("/owner/{ownerId}/pet")
	public PetModel createComment(@PathVariable (value = "ownerId") Long ownerId, @Valid @RequestBody PetModel petModel)
	{
		return myRepository.findById(ownerId)
				.map(OwnerModel -> {petModel.setOwner(OwnerModel);
				return petRepository.save(petModel);})
				.orElseThrow(() -> new ResourceNotFoundException("Owner", "id", petModel));
	}

	//Method to GET ONE owner
//	@GetMapping("owner/{id}/pet/{petId}")
//	public OwnerModel getOwnerbyID(@PathVariable(value = "id")Long ownerID)
//	{
//			return myRepository.findById(ownerID)
//				.orElseThrow(()-> new ResourceNotFoundException("OwnerModel","id",ownerID));
//	}
	
	//Get ALL pets from the owner 
	@GetMapping("/owner/{ownerId}/pet")
	public Page<PetModel> getAllPetByOwnerId(@PathVariable(value = "ownerId") Long ownerId, Pageable pageable)
	{
		return petRepository.findByOwnerId(ownerId, pageable);
	}
	
	@PutMapping("/owner/{ownerId}/pet/{petId}")
	public PetModel updatePetModel(@PathVariable(value = "ownerId") Long ownerId, @PathVariable (value = "petId") Long petId, @Valid @RequestBody PetModel petRequest)
	{
		if(!myRepository.existsById(ownerId))
		{
			throw new ResourceNotFoundException("Person", "id", petRequest); 
		}
		
		return petRepository.findById(petId).map(pet -> 
				{
					pet.setName(petRequest.getName());
					pet.setMedicalHistory(petRequest.getMedicalHistory());
					return petRepository.save(pet);
				}).orElseThrow(()-> new ResourceNotFoundException("PetModelId", "id", petRequest));
	}
	
	@DeleteMapping("/owner/{ownerId}/pet/{petId}")
	public ResponseEntity<?> deletComment(@PathVariable(value = "ownerId") Long ownerId, @PathVariable (value = "petId") Long petId)
	{
		if(!petRepository.existsById(ownerId))
		{
			throw new ResourceNotFoundException("Owner", "id", ownerId);
		}
	
		return petRepository.findById(petId).map(petModel -> 
		{
			petRepository.delete(petModel);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PetModel Id", petId.toString(), null));
	}
}
