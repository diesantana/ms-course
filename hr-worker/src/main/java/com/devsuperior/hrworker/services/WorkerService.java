package com.devsuperior.hrworker.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.hrworker.dtos.WorkerDTO;
import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.exceptions.ResourceNotFoundException;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository workerRepository;

	@Transactional(readOnly = true)
	public List<WorkerDTO> findAll() {
		List<WorkerDTO> workers = workerRepository.findAll()
				.stream()
				.map(x -> new WorkerDTO(x))
				.collect(Collectors.toList());
		
		return  workers;
	}
	
	@Transactional(readOnly = true)
	public WorkerDTO findById(Long id) {
		Worker worker = workerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		
		return  new WorkerDTO(worker);
	}
}
