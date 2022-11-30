package com.mdrdevapi.api.service;

import com.mdrdevapi.api.framework.AbstractTokenizationService;
import com.mdrdevapi.api.requestDtos.tokenRequestDto;
import com.mdrdevapi.api.responseDtos.tokenResponseDto;
import org.springframework.http.ResponseEntity;

public abstract class TokenService extends AbstractTokenizationService<tokenRequestDto, tokenResponseDto> {
    public abstract ResponseEntity<tokenResponseDto> getTokenizationService(tokenRequestDto request);
}
