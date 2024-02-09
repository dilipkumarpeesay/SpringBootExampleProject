package com.example.spring.boot.docker.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Employee_TBL")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
@Id
@GeneratedValue
	private Integer id;
	private String name;
	private Integer salary;
	public String getName() {
		return name;
	}
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
