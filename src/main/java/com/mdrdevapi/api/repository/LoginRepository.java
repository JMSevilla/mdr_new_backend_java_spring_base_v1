package com.mdrdevapi.api.repository;
import com.mdrdevapi.api.responseDtos.LoginResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdrdevapi.api.entity.BusinessOwnerEntity;

import java.util.List;

@Repository
@Transactional
public interface LoginRepository extends JpaRepository<BusinessOwnerEntity, String> {
    @Query(value="SELECT * FROM restful_api_businessowner1 u WHERE u.email = ?1", nativeQuery = true)
    public List<BusinessOwnerEntity> findBusinessOwnerByEmail(String email);
}
