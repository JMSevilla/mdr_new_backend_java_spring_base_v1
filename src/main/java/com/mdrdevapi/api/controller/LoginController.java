package com.mdrdevapi.api.controller;

import com.mdrdevapi.api.requestDtos.LoginRequestDto
        ;
import com.mdrdevapi.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login/")
public class LoginController implements LoginService {
    @Autowired
    private LoginService loginService;

    @PostMapping("authenticate")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) throws Exception {
        return loginService.login(loginRequestDto);
    }
}
