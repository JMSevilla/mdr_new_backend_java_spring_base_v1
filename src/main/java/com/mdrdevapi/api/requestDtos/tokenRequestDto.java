package com.mdrdevapi.api.requestDtos;

import com.mdrdevapi.api.framework.BaseTokenRequestDto;
import lombok.Data;

@Data
public class tokenRequestDto extends BaseTokenRequestDto<tokenRequestDto> {
    private String userid;
    private String token;
}
