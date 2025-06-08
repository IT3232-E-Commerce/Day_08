package com.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.model.Department;
import com.system.repository.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;

	public List<Department> getDepts() {
		return repo.findAll();
	}

	public Department getDept(int id) {
		if (repo.findById(id).isEmpty()) {
			return null;
		}
		return repo.findById(id).get();
	}

	public String addDept(Department department) {
		if (repo.findById(department.getId()).isPresent()) {
			return "Department already exists.";
		}
		repo.save(department);
		return "New department added.";
	}

	public String updateDept(int id, Department department) {
		if (repo.existsById(id)) {
			repo.save(department);
			return "Department updated.";
		}
		return "Department not exists.";
	}

	public String deleteDept(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Department deleted.";
		}
		return "Department not exists.";
	}
}
