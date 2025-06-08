package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.model.Department;
import com.system.service.DepartmentService;

@RestController
@RequestMapping("/deparment")
public class DepartmentController {
	@Autowired
	private DepartmentService service;

	@GetMapping("/")
	public ResponseEntity<List<Department>> getDeps() {
		return new ResponseEntity<List<Department>>(service.findDeps(), HttpStatus.OK);
	}
}
