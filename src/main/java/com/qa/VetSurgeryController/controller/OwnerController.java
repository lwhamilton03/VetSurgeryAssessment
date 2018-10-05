package com.qa.VetSurgeryController.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.VetSurgeryException.exception.ResourceNotFoundException;
import com.qa.VetSurgeryModel.model.OwnerModel;
import com.qa.VetSurgeryRepository.repository.OwnerRepository;





@RestController
@RequestMapping("/api")
public class OwnerController {

	@Autowired
	OwnerRepository myRepository;
	
	//Method to CREATE an owner 
	@PostMapping("/OwnerModel")
	public OwnerModel createPerson(@Valid @RequestBody OwnerModel mSDM) 
	{
		return myRepository.save(mSDM);
	}
	
	//Method to GET an owner
	@GetMapping("owner/{id}")
	public OwnerModel getPersonbyID(@PathVariable(value = "id")Long ownerID)
	{
		return myRepository.findById(ownerID)
			.orElseThrow(()-> new ResourceNotFoundException("OwnerModel","id",ownerID));
	}
	
	//Method to GET ALL owners
	@GetMapping("/owner")
	public List<OwnerModel> getAllPeople()
	{
		return myRepository.findAll();
	}
		
	//Method to UPDATE an owner
	@PutMapping("/owner/{id}")
	public OwnerModel updatePerson(@PathVariable(value = "id") Long ownerID,
		@Valid @RequestBody OwnerModel personDetails)
	{
			
		OwnerModel mSDM = myRepository.findById(ownerID).orElseThrow(()-> new ResourceNotFoundException("Person","id",ownerID));
	
		mSDM.setName(personDetails.getName());
		mSDM.setAddress(personDetails.getAddress());
		mSDM.setContactNum(personDetails.getContactNum());
		
		OwnerModel updateData = myRepository.save(mSDM);
		return updateData;
	}
	
	//Method to DELETE an owner
	@DeleteMapping("/owner/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id")Long ownerID) {
		OwnerModel mSDM =  myRepository.findById(ownerID).orElseThrow(()-> new ResourceNotFoundException("Person","id",ownerID));
		
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
}
