package com.mdrdevapi.api.serviceImpl;

import com.mdrdevapi.api.constants.controllerConstant;
import com.mdrdevapi.api.entity.BusinessOwnerEntity;
import com.mdrdevapi.api.repository.UserRepository;
import com.mdrdevapi.api.requestDtos.CreateUserRequestDto;
import com.mdrdevapi.api.responseDtos.CreateUserResponseDto;
import com.mdrdevapi.api.service.CreateUserService;
import com.mdrdevapi.api.utils.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class CreateUserServiceImpl extends CreateUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<CreateUserResponseDto> createUser(CreateUserRequestDto request) throws Exception {
        AESUtil aesUtil = new AESUtil();
        BusinessOwnerEntity businessOwnerEntity = new BusinessOwnerEntity();
        businessOwnerEntity.setFirstname(request.getFirstname());
        businessOwnerEntity.setLastname(request.getLastname());
        businessOwnerEntity.setContactnumber(request.getContactnumber());
        businessOwnerEntity.setAddress(request.getAddress());
        businessOwnerEntity.setEmail(request.getEmail());
        businessOwnerEntity.setPassword(aesUtil.encrypt(request.getPassword()));
        businessOwnerEntity.setUsertype("3");
        businessOwnerEntity.setIslock("1");
        businessOwnerEntity.setIsverified("0");
        businessOwnerEntity.setImgurl("None");
        businessOwnerEntity.setSec_question(request.getSec_question());
        businessOwnerEntity.setSec_answer(request.getSec_answer());
        businessOwnerEntity.setCreated_at(new Timestamp(new Date().getTime()));
        businessOwnerEntity.setUpdated_at(new Timestamp(new Date().getTime()));
        return new ResponseEntity<>(createUserResponseDto(userRepository.save(businessOwnerEntity)), HttpStatus.OK);
    }
    public CreateUserResponseDto createUserResponseDto(BusinessOwnerEntity businessOwnerEntity){
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
        createUserResponseDto.setSuccess(String.valueOf(controllerConstant.CREATED));
        return createUserResponseDto;
    }
}
