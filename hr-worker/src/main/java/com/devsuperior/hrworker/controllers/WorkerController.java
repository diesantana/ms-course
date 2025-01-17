package com.devsuperior.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.dtos.WorkerDTO;
import com.devsuperior.hrworker.services.WorkerService;


@RestController
@RequestMapping("/workers")
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;
	
	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll() 	{
		List<WorkerDTO> response = workerService.findAll();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id) {
		WorkerDTO response = workerService.findById(id);
		return ResponseEntity.ok(response);
	}
}
