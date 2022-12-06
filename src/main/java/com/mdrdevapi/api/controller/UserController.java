package com.mdrdevapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdrdevapi.api.framework.AbstractCreateUserController;
import com.mdrdevapi.api.requestDtos.CreateUserRequestDto;
import com.mdrdevapi.api.requestDtos.EmailDetailsRequestDto;
import com.mdrdevapi.api.responseDtos.CreateUserResponseDto;
import com.mdrdevapi.api.service.AccountVerificationService;
import com.mdrdevapi.api.service.CreateUserService;

@RestController
@RequestMapping("api/users/")
public class UserController extends AbstractCreateUserController<CreateUserRequestDto, CreateUserResponseDto> {
    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private AccountVerificationService accountVerificationService;

    @PostMapping("create-user")
    public ResponseEntity<CreateUserResponseDto> userCreation(@RequestBody CreateUserRequestDto request) throws Exception {
        return createUserService.createUser(request);
    }

	@GetMapping("check-email/{email}/{type}")
	public ResponseEntity<?> checkUserEmail(@PathVariable String email, @PathVariable int type) {
		return createUserService.checkUserByEmail(email, type);
	}

	@GetMapping("check-sent-count/{email}")
	public ResponseEntity<?> checkSentCountByEmail(@PathVariable String email) {
		return accountVerificationService.findAllAccountVerificationByEmail(email);
	}

	@GetMapping("compare-verification-code/{email}/{code}")
	public ResponseEntity<?> compareVerification(@PathVariable String email, @PathVariable String code) {
		return accountVerificationService.findAndCompareVerificationCode(email, code);
	}

	@PutMapping("business-update-with-send/{email}/{code}")
	public ResponseEntity<?> updateSentCountWithEmail(@PathVariable String email, @PathVariable String code) {
		return accountVerificationService.updateSentEmailIfExist(email, code);
	}

	@PostMapping("verification-entry")
	public ResponseEntity<?> createVerificationRecord(@RequestBody EmailDetailsRequestDto emailDetailsRequestDto) {
		return accountVerificationService.createVerificationRecord(emailDetailsRequestDto);
	}

	@GetMapping("getall-businessbyemail/{email}")
	public ResponseEntity<?> findAllBusinessOwnerByEmail(@PathVariable String email) {
		return createUserService.findAllBusinessOwnerByEmail(email);
	}

	@PostMapping("student/registration")
	public ResponseEntity<CreateUserResponseDto> studentCreation(@RequestBody CreateUserRequestDto request) throws Exception {
		return createUserService.createUserStudent(request);
	}


}
