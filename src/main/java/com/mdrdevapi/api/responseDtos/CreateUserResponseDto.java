package com.mdrdevapi.api.responseDtos;

import com.mdrdevapi.api.framework.BaseCreateUserResponseDto;
import lombok.Data;
@Data
public class CreateUserResponseDto extends BaseCreateUserResponseDto<CreateUserResponseDto> {
    private String success;
}
