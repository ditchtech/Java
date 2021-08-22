package com.restdemo.RestDemo.Entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MARKS")
public class Marks {
	
	@Id
	@GeneratedValue
	private Long marksid;
	
	public Long getMarksid() {
		return marksid;
	}

	public void setMarksid(Long marksid) {
		this.marksid = marksid;
	}

	public int getSemester() {
		return Semester;
	}

	public void setSemester(int semester) {
		Semester = semester;
	}

	public String getMathsMarks() {
		return mathsMarks;
	}

	public void setMathsMarks(String mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public String getHistoryMarks() {
		return historyMarks;
	}

	public void setHistoryMarks(String historyMarks) {
		this.historyMarks = historyMarks;
	}

	public String getBioMarks() {
		return bioMarks;
	}

	public void setBioMarks(String bioMarks) {
		this.bioMarks = bioMarks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}



	private int Semester;
	private String mathsMarks;
	private String historyMarks;
	private String bioMarks;
	
	@ManyToOne
	@JsonIgnore
	private Student student;
}
