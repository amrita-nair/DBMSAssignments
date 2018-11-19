package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "FACULTY")
public class Faculty extends Person{


	public Faculty(String username, String password, String firstName, String lastName, String office, boolean tenure) {
		super(username, password, firstName, lastName);
		this.office = office;
		this.tenure = tenure;

	}

	private String office;
	private boolean tenure;
	
	@OneToMany(mappedBy="author", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	@Fetch(value = FetchMode.SELECT)
	private List<Course> authoredCourses;

	public Faculty() {}
	
	public Faculty(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public boolean isTenure() {
		return tenure;
	}
	public void setTenure(boolean tenure) {
		this.tenure = tenure;
	}
	
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}
	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}
	
	public void authoredCourse(Course course) {
	     this.authoredCourses.add(course);
	     if(course.getAuthor() != this)
	        course.setAuthor(this);
	}
}
