package com.mdrdevapi.api.framework;

import org.springframework.http.ResponseEntity;

public abstract class AbstractCreateUserService <T extends BaseCreateUserRequestDto<T>> {
    public abstract ResponseEntity<?> createUser(T request) throws Exception;
}
