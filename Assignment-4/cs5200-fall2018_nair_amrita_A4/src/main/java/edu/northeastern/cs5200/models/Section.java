package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int seats;
	@ManyToMany(mappedBy = "enrolledSections",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.JOIN)
	@JsonIgnore
	private List<Student> enrolledStudents = new ArrayList();
	
	public void enrollStudent(Student student) {
		this.enrolledStudents.add(student);
		if(!student.getEnrolledSections().contains(this)) {
			student.getEnrolledSections().add(this);
		}
	}
	@ManyToOne(fetch=FetchType.EAGER)
	private Course course;

	
	
	
	public Section() {
		
	}

	public Section(String title, int seats, Course course) {
		super();
		this.title = title;
		this.seats = seats;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents.clear();
		this.enrolledStudents.addAll(enrolledStudents);
	}

}
