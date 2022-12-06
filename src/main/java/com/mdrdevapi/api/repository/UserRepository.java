package com.mdrdevapi.api.repository;
import com.mdrdevapi.api.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdrdevapi.api.entity.BusinessOwnerEntity;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<BusinessOwnerEntity, String> {
	@Query(value="SELECT CASE WHEN EXISTS (SELECT * FROM restful_api_businessowner1 u WHERE u.email = ?1) THEN true ELSE FALSE END", nativeQuery = true)
	Boolean findBusinessOwnerByEmail(String email);

	@Query(value="SELECT * FROM restful_api_businessowner1 u WHERE u.email=:email", nativeQuery = true)
	List<BusinessOwnerEntity> findAllBusinessOwnerByEmail(@Param("email") String email);
}

