package com.mdrdevapi.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdrdevapi.api.entity.BusinessOwnerEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<BusinessOwnerEntity, String> {
	
}
