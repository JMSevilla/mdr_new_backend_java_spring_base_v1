package com.mdrdevapi.api.service;

import com.mdrdevapi.api.requestDtos.LoginRequestDto;
import com.mdrdevapi.api.responseDtos.LoginResponseDto;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    public ResponseEntity<?> login(LoginRequestDto loginRequestDto) throws Exception;
}
