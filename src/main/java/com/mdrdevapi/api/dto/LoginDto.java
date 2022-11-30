package com.mdrdevapi.api.dto;
import lombok.Data;
@Data
public class LoginDto {
    private String firstname;
    private String lastname;
    private String email;
    private Long id;
    private String successMessage;
    private String usertype;
    private String token;
    private String password;
    private String islock;
    private String isvalid;
    private String lastroute;
}
