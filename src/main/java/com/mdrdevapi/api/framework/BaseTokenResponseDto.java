package com.mdrdevapi.api.framework;
import lombok.Data;
@Data
public class BaseTokenResponseDto<T extends BaseTokenResponseDto<T>> {
    private Long id;
    private Long userid;
    private String token;
    private String lastroute;
    private String isdestroyed;
    private String isvalid;
}
