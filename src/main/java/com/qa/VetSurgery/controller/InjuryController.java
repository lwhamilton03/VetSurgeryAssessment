//package com.qa.VetSurgery.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.qa.VetSurgery.exception.ResourceNotFoundException;
//import com.qa.VetSurgery.model.InjuryModel;
//import com.qa.VetSurgery.model.PetModel;
//import com.qa.VetSurgery.repository.InjuryRepository;
//
//import com.qa.VetSurgery.repository.PetRepository;
//
//@RestController
//@RequestMapping("/api")
//public class InjuryController {
//
//	@Autowired
//	private InjuryRepository injuryRepository;
//	
//	@Autowired
//	private PetRepository myRepository; 

	//Posting a pet to a owner 
//	@PostMapping("/owner/{ownerId}/pet/{petId}/injury")
//	public InjuryModel createComment(@PathVariable (value = "petId") Long petId, @Valid @RequestBody InjuryModel injuryModel)
//	{
//		return myRepository.findById(petId)
//				.map(PetModel -> {injuryModel.setPet(PetModel);
//				return injuryRepository.save(injuryModel);})
//				.orElseThrow(() -> new ResourceNotFoundException("Pet", "id", injuryModel));
//	}


}
