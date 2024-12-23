package com.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Student")
public class Studententity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String course;
	private Double fee;
	
	
	@OneToMany(targetEntity = StudentAddress.class, cascade = CascadeType.ALL)
	@JoinColumn(name="Student_id", referencedColumnName = "id")
private List<StudentAddress> addresses;
}
