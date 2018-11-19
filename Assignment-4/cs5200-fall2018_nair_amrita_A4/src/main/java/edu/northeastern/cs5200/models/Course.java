package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Entity
public class Course {
  @Id
 // @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String label;
  @ManyToOne()
  //@PersistenceContext(type=PersistenceContextType.EXTENDED)
  private Faculty author;
  
  @OneToMany(fetch=FetchType.EAGER, mappedBy="course")
  private List<Section> sections;
  
  
  
  public Course(String label, Faculty author) {
	super();
	this.label = label;
	this.author = author;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public List<Section> getSections() {
	return sections;
}

public Course() {
	
}
public void setSections(List<Section> sections) {
	this.sections = sections;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public Faculty getAuthor() {
	return author;
}

public void setAuthor(Faculty author) {
	     this.author = author;
	     if(!author.getAuthoredCourses()
	.contains(this)) {
	        author.getAuthoredCourses()
	        .add(this);
	}
  }


}
