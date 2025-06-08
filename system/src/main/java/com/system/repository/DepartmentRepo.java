package com.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
