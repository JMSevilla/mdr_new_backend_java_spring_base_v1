package com.mdrdevapi.api.service;

import org.springframework.http.ResponseEntity;

import com.mdrdevapi.api.requestDtos.EmailDetailsRequestDto;

public interface AccountVerificationService {
	ResponseEntity<?> findAllAccountVerificationByEmail(String email);
	ResponseEntity<?> findAndCompareVerificationCode(String email, String code);
	ResponseEntity<?> updateSentEmailIfExist(String email, String code);
	ResponseEntity<?> createVerificationRecord(EmailDetailsRequestDto emailDetailsRequestDto);
}
