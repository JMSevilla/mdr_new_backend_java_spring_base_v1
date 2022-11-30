package com.mdrdevapi.api.framework;
import lombok.Data;
@Data
public class BaseCreateUserRequestDto <T extends BaseCreateUserRequestDto<T>> {
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
