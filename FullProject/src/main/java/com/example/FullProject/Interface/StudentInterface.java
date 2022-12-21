package com.example.FullProject.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FullProject.model.Student;


public interface StudentInterface extends JpaRepository<Student,Integer>{
	

}


