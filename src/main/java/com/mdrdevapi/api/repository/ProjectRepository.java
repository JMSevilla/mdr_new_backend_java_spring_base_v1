package com.mdrdevapi.api.repository;

import com.mdrdevapi.api.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<ProjectEntity, String> {
    @Query(value="SELECT * FROM restful_api_project u WHERE u.client_email=:email", nativeQuery = true)
    List<ProjectEntity> findAllProjectsByEmail(@Param("email") String email);
}
