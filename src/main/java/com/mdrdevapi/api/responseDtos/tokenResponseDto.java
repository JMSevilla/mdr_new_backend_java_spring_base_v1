package com.mdrdevapi.api.responseDtos;
import com.mdrdevapi.api.framework.BaseTokenResponseDto;
import lombok.Data;
@Data
public class tokenResponseDto extends BaseTokenResponseDto<tokenResponseDto> {
 private Long id;
 private Long userid;
 private String token;
 private String lastroute;
 private String isdestroyed;
 private String isvalid;
}
