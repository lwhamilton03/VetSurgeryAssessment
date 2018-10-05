package com.qa.VetSurgeryRepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.VetSurgeryModel.model.OwnerModel;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerModel, Long>{

}
