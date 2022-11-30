package com.mdrdevapi.api.responseDtos;
import lombok.Data;
@Data
public class LoginResponseDto {
    private String firstname;
    private String lastname;
    private String email;
    private String SuccessMessage;
    private String type;
    private Long userid;
    private String token;
}
