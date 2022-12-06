package com.mdrdevapi.api.serviceImpl;

import com.mdrdevapi.api.constants.CheckEmailConstant;
import com.mdrdevapi.api.constants.controllerConstant;
import com.mdrdevapi.api.entity.BusinessOwnerEntity;
import com.mdrdevapi.api.entity.StudentEntity;
import com.mdrdevapi.api.repository.StudentRepository;
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
import java.util.List;

@Service
public class CreateUserServiceImpl extends CreateUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;
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
    public CreateUserResponseDto createStudentResponseDto(StudentEntity studentEntity){
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
        createUserResponseDto.setSuccess(String.valueOf(controllerConstant.CREATED));
        return createUserResponseDto;
    }
	@Override
	public ResponseEntity<?> checkUserByEmail(String email, int type) {
		CheckEmailConstant constant = CheckEmailConstant.values()[type];
		switch(constant) {
		case BUSINESS_OWNER:
			if(userRepository.findBusinessOwnerByEmail(email)) {
				return ResponseEntity.status(HttpStatus.OK).body("exist");
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body("not_exist");
			}
		default:
			return ResponseEntity.status(HttpStatus.OK).body("BADR");
		}
	}

    @Override
    public ResponseEntity<?> findAllBusinessOwnerByEmail(String email) {
        List<BusinessOwnerEntity> businessOwnerEntityList = userRepository.findAllBusinessOwnerByEmail(email);
        if(!businessOwnerEntityList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(businessOwnerEntityList);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no_record_found");
    }

    @Override
    public ResponseEntity<CreateUserResponseDto> createUserStudent(CreateUserRequestDto request) throws Exception {
        AESUtil aesUtil = new AESUtil();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstname(request.getFirstname());
        studentEntity.setLastname(request.getLastname());
        studentEntity.setContactnumber(request.getContactnumber());
        studentEntity.setAddress(request.getAddress());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setPassword(aesUtil.encrypt(request.getPassword()));
        studentEntity.setUsertype("3");
        studentEntity.setIslock("1");
        studentEntity.setIsverified("0");
        studentEntity.setImgurl("None");
        studentEntity.setSec_question(request.getSec_question());
        studentEntity.setSec_answer(request.getSec_answer());
        studentEntity.setCreated_at(new Timestamp(new Date().getTime()));
        studentEntity.setUpdated_at(new Timestamp(new Date().getTime()));
        return new ResponseEntity<>(createStudentResponseDto(studentRepository.save(studentEntity)), HttpStatus.OK);
    }
}
