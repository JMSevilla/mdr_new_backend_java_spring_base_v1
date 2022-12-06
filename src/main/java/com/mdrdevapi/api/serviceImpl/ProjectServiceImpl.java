package com.mdrdevapi.api.serviceImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdrdevapi.api.entity.ProjectEntity;
import com.mdrdevapi.api.repository.ProjectRepository;
import com.mdrdevapi.api.requestDtos.ProjectRequestDto;
import com.mdrdevapi.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ResponseEntity<?> projectCreation(ProjectRequestDto projectRequestDto) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectname(projectRequestDto.getProjectname());
        projectEntity.setProjectdetails(projectRequestDto.getProjectdetails());
        projectEntity.setProjectcategory(projectRequestDto.getProjectcategory());
        projectEntity.setProjecttype(projectRequestDto.getProjecttype());
        projectEntity.setProjectfeatures(projectRequestDto.getProjectfeatures());
        projectEntity.setProjectprice(projectRequestDto.getProjectprice());
        projectEntity.setClientEmail(projectRequestDto.getEmail());
        projectEntity.setProjectstatus("0");
        projectEntity.setCreated_at(new Timestamp(new Date().getTime()));
        projectEntity.setUpdated_at(new Timestamp(new Date().getTime()));
        projectRepository.save(projectEntity);
        return ResponseEntity.status(HttpStatus.OK).body("success_project_entry");
    }

    @Override
    public ResponseEntity<?> findAllProjectsByEmail(String email) {
        List<ProjectEntity> projectEntityList = projectRepository.findAllProjectsByEmail(email);
        if(!projectEntityList.isEmpty()){
            return new ResponseEntity<>(projectEntityList, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.OK).body("no_project_found");
    }
}
