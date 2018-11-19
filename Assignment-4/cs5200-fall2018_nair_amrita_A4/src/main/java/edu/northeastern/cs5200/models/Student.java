package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.JoinColumn;

@Entity
public class Student extends Person {
	private int gradYear;
	private int scholarship;
	
	public Student() {}
	
	public Student(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}
	public Student(String username, String password, String firstName, String lastName, int gradYear, int scholarship) {
		super(username, password, firstName, lastName);
		this.gradYear = gradYear;
		this.scholarship = scholarship;

	}
	@ManyToMany(fetch=FetchType.EAGER)
	  @JoinTable(name="ENROLLMENT",
	     joinColumns=@JoinColumn(name="STUDENT_ID",
	     referencedColumnName="personId"),
	     inverseJoinColumns=@JoinColumn(name=
	        "SECTION_ID", referencedColumnName="id"))
	@Fetch(value = FetchMode.JOIN)
	private List<Section> enrolledSections = new ArrayList();
	
	public void enrollSection(Section section) {
		this.enrolledSections.add(section);
		if(!section.getEnrolledStudents().contains(this)) {
			section.getEnrolledStudents().add(this);
		}
	}	
	
	public int getGradYear() {
		return gradYear;
	}
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	public int getScholarship() {
		return scholarship;
	}
	public void setScholarship(int scholarship) {
		this.scholarship = scholarship;
	}
	public List<Section> getEnrolledSections() {
		return enrolledSections;
	}
	public void setEnrolledSections(List<Section> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}
	
	
}
