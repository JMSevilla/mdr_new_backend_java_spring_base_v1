package com.mdrdevapi.api.serviceImpl;

import com.mdrdevapi.api.constants.controllerConstant;
import com.mdrdevapi.api.dto.LoginDto;
import com.mdrdevapi.api.entity.BusinessOwnerEntity;
import com.mdrdevapi.api.entity.TokenEntity;
import com.mdrdevapi.api.repository.LoginRepository;
import com.mdrdevapi.api.repository.TokenRepository;
import com.mdrdevapi.api.requestDtos.LoginRequestDto;
import com.mdrdevapi.api.responseDtos.LoginResponseDto;
import com.mdrdevapi.api.service.LoginService;
import com.mdrdevapi.api.utils.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private TokenRepository tokenRepository;
    @Override
    public ResponseEntity<?> login(LoginRequestDto loginRequestDto) throws Exception {
        AESUtil aesUtil = new AESUtil();
        TokenEntity tokenEntity = new TokenEntity();
        List<BusinessOwnerEntity> businessOwnerEntityList = loginRepository.findBusinessOwnerByEmail(loginRequestDto.getEmail());
        LoginDto loginDto = new LoginDto();
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        businessOwnerEntityList.forEach(item -> {
            loginDto.setFirstname(item.getFirstname());
            loginDto.setLastname(item.getLastname());
            loginDto.setEmail(item.getEmail());
            loginDto.setPassword(item.getPassword());
            loginDto.setUsertype(item.getUsertype());
            loginDto.setId(item.getId());
        });
        if(loginRequestDto.getPassword() == aesUtil.decrypt(loginDto.getPassword())){
            if(loginDto.getIslock() == "1"){
                return ResponseEntity.status(HttpStatus.OK).body(controllerConstant.ACCOUNT_LOCK);
            }else{
                if(loginDto.getUsertype() == "3"){
                    /* Business Owner */
                    List<TokenEntity> tokenEntityList = tokenRepository.findTokenById(loginDto.getId());
                    tokenEntityList.forEach(snapshot -> {
                        loginDto.setToken(snapshot.getToken());
                        loginDto.setIsvalid(snapshot.getIsvalid());
                        loginDto.setLastroute(snapshot.getLastroute());
                        loginDto.setToken(aesUtil.encrypt(snapshot.getToken()));
                    });
                    if(loginDto.getIsvalid() == "0"){
                        tokenQueryBuild(loginDto);
                        loginResponseDto.setFirstname(loginDto.getFirstname());
                        loginResponseDto.setLastname(loginDto.getLastname());
                        loginResponseDto.setEmail(loginDto.getEmail());
                        loginResponseDto.setUserid(loginDto.getId());
                        loginResponseDto.setToken(aesUtil.encrypt(loginDto.getToken()));
                        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
                    }
                }
                else if(loginDto.getUsertype() == "2"){}
                else if(loginDto.getUsertype() == "1"){}
            }
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(controllerConstant.INVALID_PASSWORD);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public LoginResponseDto createResponseAfterLogin(BusinessOwnerEntity businessOwnerEntity){
        return null;
    }
    public ResponseEntity<?> tokenQueryBuild(LoginDto loginDto){
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUserid(loginDto.getId());
        tokenEntity.setToken(loginDto.getToken());
        tokenEntity.setLastroute(loginDto.getLastroute());
        tokenEntity.setIsdestroyed("0");
        tokenEntity.setIsvalid("1");
        return new ResponseEntity<>(tokenRepository.save(tokenEntity), HttpStatus.OK);
    }
}
