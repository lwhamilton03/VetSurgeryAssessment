package com.qa.VetSurgery.controller;

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

import com.qa.VetSurgery.exception.ResourceNotFoundException;
import com.qa.VetSurgery.model.OwnerModel;
import com.qa.VetSurgery.repository.OwnerRepository;


@RestController
@RequestMapping("/api")
public class OwnerController {

	@Autowired
	OwnerRepository myRepository;
	
	//Method to CREATE an owner 
	@PostMapping("/owner")
	public OwnerModel createOwner(@Valid @RequestBody OwnerModel mSDM) 
	{
		return myRepository.save(mSDM);
	}
	
	//Method to GET an owner
	@GetMapping("owner/{id}")
	public OwnerModel getOwnerbyID(@PathVariable(value = "id")Long ownerID)
	{
		return myRepository.findById(ownerID)
			.orElseThrow(()-> new ResourceNotFoundException("OwnerModel","id",ownerID));
	}
	
	//Method to GET ALL owners
	@GetMapping("/owner")
	public List<com.qa.VetSurgery.model.OwnerModel> getAllOwner()
	{
		return myRepository.findAll();
	}
		
	//Method to UPDATE an owner
	@PutMapping("/owner/{id}")
	public com.qa.VetSurgery.model.OwnerModel updateOwner(@PathVariable(value = "id") Long ownerID,
		@Valid @RequestBody com.qa.VetSurgery.model.OwnerModel ownerDetails)
	{
			
		OwnerModel mSDM = myRepository.findById(ownerID).orElseThrow(()-> new ResourceNotFoundException("Owner","id",ownerID));
	
		mSDM.setName(ownerDetails.getName());
		mSDM.setAddress(ownerDetails.getAddress());
		mSDM.setContactNum(ownerDetails.getContactNum());
		
		OwnerModel updateData = myRepository.save(mSDM);
		return updateData;
	}
	
	//Method to DELETE an owner
	@DeleteMapping("/owner/{id}")
	public ResponseEntity<?> deleteOwner(@PathVariable(value = "id")Long ownerID) {
		OwnerModel mSDM =  myRepository.findById(ownerID).orElseThrow(()-> new ResourceNotFoundException("Owner","id",ownerID));
		
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
}
