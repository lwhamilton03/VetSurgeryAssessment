package com.qa.VetSurgery.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.VetSurgery.model.PetModel;

@Repository
public interface PetRepository extends JpaRepository<PetModel, Long>
{
	Page<PetModel> findByOwnerId(Long ownerId, Pageable pageable);
}
