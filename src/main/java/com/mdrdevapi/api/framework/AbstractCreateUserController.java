package com.mdrdevapi.api.framework;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "v1/base/user")
public abstract class AbstractCreateUserController <T extends BaseCreateUserRequestDto<T>, K extends BaseCreateUserResponseDto<K>> {
    public abstract ResponseEntity<K> userCreation(T request) throws Exception;
}
