package com.mdrdevapi.api.controller;

import com.mdrdevapi.api.constants.controllerConstant;
import com.mdrdevapi.api.framework.AbstractTokenizationController;
import com.mdrdevapi.api.requestDtos.tokenRequestDto;
import com.mdrdevapi.api.responseDtos.tokenResponseDto;
import com.mdrdevapi.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tokenization/")
public class TokenController extends AbstractTokenizationController<tokenRequestDto, tokenResponseDto> {
    @Autowired
    private TokenService tokenService;

    @PostMapping("gettokenbyparams")
    public ResponseEntity<?> getTokenization(tokenRequestDto request) {
        tokenResponseDto responseDto = new tokenResponseDto();
        if(request.getUserid() == "unknown"){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            if(responseDto.getIsvalid() == "1"){
                if(responseDto.getLastroute() == "business_platform"){
                    return new ResponseEntity<>(responseDto, HttpStatus.OK);
                }
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("invalid_token");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("invalid_token");
    }
}
