package com.mdrdevapi.api.framework;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdrdevapi.api.requestDtos.EmailDetailsRequestDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "v1/base/user")
public abstract class AbstractCreateUserController <T extends BaseCreateUserRequestDto<T>, K extends BaseCreateUserResponseDto<K>> {
    public abstract ResponseEntity<K> userCreation(T request) throws Exception;
    public abstract ResponseEntity<?> checkUserEmail(String email, int type);
    public abstract ResponseEntity<?> checkSentCountByEmail(String email);
    public abstract ResponseEntity<?> compareVerification(String email, String code);
    public abstract ResponseEntity<?> updateSentCountWithEmail(String email, String code);
    public abstract ResponseEntity<?> createVerificationRecord(EmailDetailsRequestDto emailDetailsRequestDto);

    public abstract ResponseEntity<?> findAllBusinessOwnerByEmail(String email);
    public abstract ResponseEntity<K> studentCreation(T request) throws Exception;
}
