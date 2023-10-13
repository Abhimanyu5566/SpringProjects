package com.School.Repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.School.Entity.Student;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public Student findByRollNo(int rollNo);

}
