package com.mdrdevapi.api.controller;

import com.mdrdevapi.api.framework.AbstractCreateUserController;
import com.mdrdevapi.api.requestDtos.CreateUserRequestDto;
import com.mdrdevapi.api.responseDtos.CreateUserResponseDto;
import com.mdrdevapi.api.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users/")
public class UserController extends AbstractCreateUserController<CreateUserRequestDto, CreateUserResponseDto> {
    @Autowired
    private CreateUserService createUserService;

    @PostMapping("create-user")
    public ResponseEntity<CreateUserResponseDto> userCreation(@RequestBody CreateUserRequestDto request) throws Exception {
        return createUserService.createUser(request);
    }
}
