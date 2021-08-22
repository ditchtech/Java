package com.restdemo.RestDemo.Entitites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="first_name",length = 50, nullable = false)
	private  String firstName;
	@Column(name="last_name",length = 50, nullable = false)
	private String lastName;
	@Column(name="Class",length = 50, nullable = false)
	private String stuClass;
	@Column(name="Address",length = 50, nullable = false)
	private String stuAddress;
	
	@OneToMany(mappedBy = "student")
	private List<Marks> marks;
	
	public List<Marks> getMarks() {
		return marks;
	}



	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", stuClass=" + stuClass
				+ ", stuAddress=" + stuAddress + "]";
	}
	
	
	
	public Student() {

	}


	public Student(Long id, String firstName, String lastName, String stuClass, String stuAddress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.stuClass = stuClass;
		this.stuAddress = stuAddress;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

}
