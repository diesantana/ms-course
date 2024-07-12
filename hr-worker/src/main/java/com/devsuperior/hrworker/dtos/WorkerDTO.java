package com.devsuperior.hrworker.dtos;

import java.util.Objects;

import com.devsuperior.hrworker.entities.Worker;

public class WorkerDTO {
	private Long id;
	private String name;
	private Double dailyIncome;
	
	public WorkerDTO() {
	}
	
	public WorkerDTO(Long id, String name, Double dailyIncome) {
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}
	
	public WorkerDTO(Worker entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.dailyIncome = entity.getDailyIncome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkerDTO other = (WorkerDTO) obj;
		return Objects.equals(id, other.id);
	}
}
