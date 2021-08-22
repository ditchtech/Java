package com.restdemo.RestDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.restdemo.RestDemo.Entitites.Student;
import com.restdemo.RestDemo.exceptions.StudentNotFound;
import com.restdemo.RestDemo.service.StudentService;

@SuppressWarnings("unused")
@RestController
public class StudentController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println("Hello!");
	}

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/student")
	public List<Student> getList(){
		return studentservice.getAllStudents();
	}
	
	@GetMapping(value ={"/student/Paginated/{page}/{size}", "/student/Paginated/{page}/{size}/{sort}"})
	public Page<Student> getPagedList(@PathVariable("page") int pageNumber, @PathVariable("size") int pageSize,@PathVariable ("sort") Optional<String> sortBy){
		Pageable pageable=null;
		String sortValue=sortBy.get();
		System.out.println(pageNumber+ " "+pageSize+" "+sortValue);
		if(sortBy.isPresent()) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortValue));
			System.out.println("Sorted");
		}
		else 
			pageable = PageRequest.of(pageNumber, pageSize);	
		try {
			
			return studentservice.getPagedList(pageable);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
	@GetMapping("/student/{id}")
	public Optional<Student> getById(@PathVariable("id") Long id) {
		System.out.println(id);
		try {
			return studentservice.getById(id);
		} catch (StudentNotFound e) {
			// TODO Auto-generated catch block
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@DeleteMapping("/student/{id}")
	public boolean deleteById(@PathVariable("id") Long id){
		try {
			 studentservice.deleteStudent(id);
			 return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@PostMapping("/student")
	public void createStudent(@RequestBody Student student) {
		Student studSaved=studentservice.createStudent(student);
	}
	
	@PutMapping("/student/{id}")
	public void updateStudent(@PathVariable("id") Long id, @RequestBody Student student)
	{

		studentservice.updateStudent(student, id);
	}
	
	
}
