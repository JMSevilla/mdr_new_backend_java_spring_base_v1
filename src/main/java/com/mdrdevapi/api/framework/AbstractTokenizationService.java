package com.mdrdevapi.api.framework;

import org.springframework.http.ResponseEntity;

public abstract class AbstractTokenizationService<T extends BaseTokenRequestDto<T>, K extends BaseTokenResponseDto<K>> {
public abstract ResponseEntity<K> getTokenizationService(T request);
}
