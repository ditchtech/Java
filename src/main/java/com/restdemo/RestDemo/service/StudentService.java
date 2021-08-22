package com.restdemo.RestDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restdemo.RestDemo.Entitites.Student;
import com.restdemo.RestDemo.exceptions.StudentNotFound;
import com.restdemo.RestDemo.repositories.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository stuRepository;
	
	@Cacheable(value="students")
	public List<Student> getAllStudents(){
		return stuRepository.findAll();
	}
	
	//public 
	@Cacheable(value="student",key = "#id")
	public Optional<Student>  getById(long id) throws StudentNotFound {
		Optional<Student> studentList = stuRepository.findById(id);
		if(studentList.isPresent())		
			return  studentList;
		else throw new StudentNotFound("Student id: "+id+" does not exist");
	}
	
	public List<Student> getByClass(String stuClass){
		return stuRepository.findBystuClass(stuClass);
	}
	
	@CacheEvict(value="students", allEntries=true)
	public Student createStudent(Student stud) {
		 return stuRepository.save(stud);
		//System.out.println(studSaved.getId());
	}
	
	//@Caching(put = {@CachePut(value="student",key="#id"),@CachePut(value="students")})
	@Caching(evict= {@CacheEvict(value="student",key="#id"), @CacheEvict(value="students", allEntries=true)})
	public void updateStudent(Student stud, long id) {
		stud.setId(id);
		stuRepository.save(stud);
	}
	
	public Page<Student> getPagedList(Pageable pageable) {
		return stuRepository.findAll(pageable);
	}
	
	@Caching(evict= {@CacheEvict(value="student",key="#id"), @CacheEvict(value="students", allEntries=true)})
	public void deleteStudent(long id) {
		stuRepository.deleteById(id);
	}

}
