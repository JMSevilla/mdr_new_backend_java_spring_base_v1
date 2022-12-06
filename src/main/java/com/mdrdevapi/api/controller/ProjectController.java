package com.mdrdevapi.api.controller;

import com.mdrdevapi.api.requestDtos.ProjectRequestDto;
import com.mdrdevapi.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "project-creation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> projectCreation(@RequestBody ProjectRequestDto projectRequestDto){
        return projectService.projectCreation(projectRequestDto);
    }

    @GetMapping("getall-projectbyemail/{email}")
    public ResponseEntity<?> findAllProjectsByEmail(@PathVariable String email){
        return projectService.findAllProjectsByEmail(email);
    }
}
