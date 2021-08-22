package com.restdemo.RestDemo.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restdemo.RestDemo.Entitites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findBystuClass(String stuClass);
	
	//Page<Student> findAllStudentsPaged(Pageable pageable);
}
