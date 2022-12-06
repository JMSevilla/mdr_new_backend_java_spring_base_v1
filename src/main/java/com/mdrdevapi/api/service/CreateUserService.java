package com.mdrdevapi.api.service;

import com.mdrdevapi.api.framework.AbstractCreateUserService;
import com.mdrdevapi.api.requestDtos.CreateUserRequestDto;
import com.mdrdevapi.api.responseDtos.CreateUserResponseDto;
import org.springframework.http.ResponseEntity;

public abstract class CreateUserService extends AbstractCreateUserService<CreateUserRequestDto> {
    public abstract ResponseEntity<CreateUserResponseDto> createUser(CreateUserRequestDto request) throws Exception;
    public abstract ResponseEntity<?> checkUserByEmail(String email, int type);

    public abstract ResponseEntity<?> findAllBusinessOwnerByEmail(String email);

    public abstract ResponseEntity<CreateUserResponseDto> createUserStudent(CreateUserRequestDto request) throws Exception;
}
