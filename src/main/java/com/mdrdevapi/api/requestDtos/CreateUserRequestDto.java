package com.mdrdevapi.api.requestDtos;
import com.mdrdevapi.api.framework.BaseCreateUserRequestDto;
import lombok.Data;
@Data
public class CreateUserRequestDto extends BaseCreateUserRequestDto<CreateUserRequestDto> {
    private String firstname;
    private String lastname;
    private String contactnumber;
    private String address;
    private String email;
    private String password;
    private String isverified;
    private String sec_question;
    private String sec_answer;
}
