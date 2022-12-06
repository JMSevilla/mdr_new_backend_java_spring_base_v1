package com.mdrdevapi.api.serviceImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mdrdevapi.api.constants.controllerConstant;
import com.mdrdevapi.api.dto.helper.AccountVerificationDto;
import com.mdrdevapi.api.entity.AccountVerificationEntity;
import com.mdrdevapi.api.repository.VerificationRepository;
import com.mdrdevapi.api.requestDtos.EmailDetailsRequestDto;
import com.mdrdevapi.api.service.AccountVerificationService;

@Service
public class AccountVerificationServiceImpl implements AccountVerificationService {
	@Autowired
	private VerificationRepository verificationRepository;

	@Autowired private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") private String sender;
	@Override
	public ResponseEntity<?> findAllAccountVerificationByEmail(String email) {
		List<AccountVerificationEntity> accountVerificationDtoList = verificationRepository.checkAllAccountVerification(email);
		if(!accountVerificationDtoList.isEmpty()) {
			List<AccountVerificationEntity> accountVerificationSentCountList = verificationRepository.findBySentCount(3);
			if(!accountVerificationSentCountList.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body("exceed_limit");
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body("update_another_sent_count");
			}
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("does_not_exist");
		}
	}

	@Override
	public ResponseEntity<?> findAndCompareVerificationCode(String email, String code) {
		List<AccountVerificationEntity> accountVerificationList = verificationRepository.findVerificationByEmailAndCode(email, code);
		if(!accountVerificationList.isEmpty()) {
			verificationRepository.updateAccountVerified(email);
			if(!verificationRepository.findVerificationByEmailAndCode(email, null).isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(controllerConstant.VERIFIED_SUCCESS);
			}
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(controllerConstant.ACCOUNT_VERIFICATION_NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).body(controllerConstant.INVALID_VERIFICATION);
	}


	void SimpleModeVerificationEmail(@NotNull EmailDetailsRequestDto emailDetailRequestDto) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(emailDetailRequestDto.getClient_email());
		msg.setTo(emailDetailRequestDto.getClient_email());
		msg.setSubject("Account Verification");
		msg.setText(emailDetailRequestDto.getCode());
		javaMailSender.send(msg);
	}

	@Override
	public ResponseEntity<?> updateSentEmailIfExist(String email, String code) {
		EmailDetailsRequestDto emailDetailRequestDto = new EmailDetailsRequestDto();
		emailDetailRequestDto.setClient_email(email);
		emailDetailRequestDto.setCode(code);
		SimpleModeVerificationEmail(emailDetailRequestDto);
		verificationRepository.findAndUpdateSentCount(email, code);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}

	@Override
	public ResponseEntity<?> createVerificationRecord(EmailDetailsRequestDto emailDetailsRequestDto) {
		AccountVerificationEntity accountVerificationEntity = new AccountVerificationEntity();
		accountVerificationEntity.setClient_email(emailDetailsRequestDto.getClient_email());
		accountVerificationEntity.setVerification_code(emailDetailsRequestDto.getCode());
		accountVerificationEntity.setVerified("0");
		accountVerificationEntity.setUser_type("3");
		accountVerificationEntity.setSent_count(1);
		accountVerificationEntity.setCreated_at(new Timestamp(new Date().getTime()));
		accountVerificationEntity.setUpdated_at(new Timestamp(new Date().getTime()));
		verificationRepository.save(accountVerificationEntity);
		return ResponseEntity.status(HttpStatus.OK).body("success_vc_entry");
	}

}
