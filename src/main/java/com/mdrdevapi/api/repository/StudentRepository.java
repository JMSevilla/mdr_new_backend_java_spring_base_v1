package com.mdrdevapi.api.repository;

import com.mdrdevapi.api.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}
