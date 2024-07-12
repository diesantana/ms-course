package com.devsuperior.hrworker.exceptions.handlers;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.devsuperior.hrworker.exceptions.ResourceNotFoundException;
import com.devsuperior.hrworker.exceptions.StandardErrorDTO;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation
	.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardErrorDTO> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		StandardErrorDTO errorDTO = new StandardErrorDTO();
		errorDTO.setTimestamp(Instant.now());
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setError("Resource Not found");
		errorDTO.setMessage(e.getMessage());
		errorDTO.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
	}
	
}
