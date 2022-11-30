package com.mdrdevapi.api.framework;
import lombok.Data;
@Data
public class BaseTokenRequestDto<T extends BaseTokenRequestDto<T>> {
    private String userid;
    private String token;
}
