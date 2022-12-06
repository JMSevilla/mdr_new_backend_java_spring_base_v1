package com.mdrdevapi.api.service;

import com.mdrdevapi.api.entity.ProjectEntity;
import com.mdrdevapi.api.requestDtos.ProjectRequestDto;
import org.springframework.http.ResponseEntity;

public interface ProjectService {
    ResponseEntity<?> projectCreation(ProjectRequestDto projectRequestDto);
    ResponseEntity<?> findAllProjectsByEmail(String email);
}
