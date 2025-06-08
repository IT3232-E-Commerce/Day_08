package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.model.Department;
import com.system.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService service;

	@GetMapping
	public ResponseEntity<List<Department>> getDepts() {
		return new ResponseEntity<List<Department>>(service.getDepts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable("id") int id) {
		if (service.getDept(id) == null) {
			return new ResponseEntity<Department>(service.getDept(id), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(service.getDept(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addDept(@RequestBody Department department) {
		String result = service.addDept(department);

		if (result.equals("Department already exists.")) {
			return new ResponseEntity<>(result, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateDept(@PathVariable("id") int id, @RequestBody Department department) {
		String result = service.updateDept(id, department);
		if (result.equals("Department updated.")) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDept(@PathVariable("id") int id) {
		String result = service.deleteDept(id);
		if (result.equals("Department deleted.")) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	}
}
