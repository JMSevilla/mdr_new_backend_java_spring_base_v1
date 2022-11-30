package com.mdrdevapi.api.framework;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "v1/base")
public abstract class AbstractTokenizationController <T extends BaseTokenRequestDto<T>, K extends BaseTokenResponseDto<K>> {
    public abstract ResponseEntity<?> getTokenization(T request);
}
