package com.mdrdevapi.api.framework;

import org.springframework.http.ResponseEntity;

public abstract class AbstractCreateUserService <T extends BaseCreateUserRequestDto<T>> {
    public abstract ResponseEntity<?> createUser(T request) throws Exception;
    public abstract ResponseEntity<?> checkUserByEmail(String email, int type);

    public abstract ResponseEntity<?> findAllBusinessOwnerByEmail(String email);

    public abstract ResponseEntity<?> createUserStudent(T request) throws Exception;
}
