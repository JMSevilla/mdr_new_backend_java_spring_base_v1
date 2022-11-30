package com.mdrdevapi.api.serviceImpl;

import com.mdrdevapi.api.entity.TokenEntity;
import com.mdrdevapi.api.repository.TokenRepository;
import com.mdrdevapi.api.requestDtos.tokenRequestDto;
import com.mdrdevapi.api.responseDtos.tokenResponseDto;
import com.mdrdevapi.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TokenServiceImpl extends TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public ResponseEntity<tokenResponseDto> getTokenizationService(tokenRequestDto request) {
        List<TokenEntity> tokenEntityList = tokenRepository.findTokenByParams(request);
        return new ResponseEntity<>(createTokenResponseDto(tokenEntityList), HttpStatus.OK);
    }

    public tokenResponseDto createTokenResponseDto(List<TokenEntity> tokenEntityList){
        List<tokenResponseDto> tokenDtos = new ArrayList<>();
        tokenResponseDto response = new tokenResponseDto();
        tokenEntityList.forEach(item -> {
            response.setToken(item.getToken());
            response.setId(item.getId());
            response.setUserid(item.getUserid());
            response.setLastroute(item.getLastroute());
            response.setIsdestroyed(item.getIsdestroyed());
            response.setIsvalid(item.getIsvalid());
            tokenDtos.add(response);
        });
        return response;
    }
}
