package com.mdrdevapi.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdrdevapi.api.dto.helper.AccountVerificationDto;
import com.mdrdevapi.api.entity.AccountVerificationEntity;

@Repository
@Transactional
public interface VerificationRepository extends JpaRepository<AccountVerificationEntity, String> {
	@Query(value="SELECT * FROM restful_api_accountverification_1 u WHERE u.client_email =:email", nativeQuery = true)
	List<AccountVerificationEntity> checkAllAccountVerification(@Param("email") String email);
	
	@Query(value="SELECT * FROM restful_api_accountverification_1 u WHERE u.sent_count = ?1", nativeQuery = true)
	List<AccountVerificationEntity> findBySentCount(int sent_count);
	
	@Query(value="SELECT * FROM restful_api_accountverification_1 WHERE verification_code=:code OR client_email=:email", nativeQuery = true)
	List<AccountVerificationEntity> findVerificationByEmailAndCode(@Param("email") String email, @Param("code") String code);
	@Modifying
	@Query(value="UPDATE restful_api_accountverification_1 SET verified='1' WHERE client_email=:email", nativeQuery = true)
	void updateAccountVerified(@Param("email") String email);

	@Modifying
	@Query(value="UPDATE restful_api_accountverification_1 SET sent_count=sent_count + 1, verification_code=:code WHERE client_email =:email", nativeQuery = true)
	void findAndUpdateSentCount(@Param("email") String email, @Param("code") String code);
}
