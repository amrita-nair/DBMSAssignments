package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.PersonRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;

@Component
public class UniversityDao {
	
	static int count = 1;

	@Autowired
	FacultyRepository facultyRepository;
	public int truncateDatabase() {
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		studentRepository.deleteAll();
		facultyRepository.deleteAll();
		
		return 0;
	}
	
	@Autowired
	PersonRepository personRepository;
	public Faculty createFaculty(Faculty faculty) {
		personRepository.save(faculty); 
		return faculty;
	}
	
	public Course createCourse(Course course) {
		course.setId(count++);
		courseRepository.save(course); 
		return course;
	}
	
	@Autowired
	StudentRepository studentRepository;
	public Student createStudent(Student student) {
		studentRepository.save(student); 
		return student;
	}
	
	@Autowired
	SectionRepository sectionRepository;
	public Section createSection(Section section) {
		sectionRepository.save(section); 
		return section;
	}
	
	public Course addSectionToCourse(Section section, Course course) {
		
		List<Section> sections = course.getSections();
		sections.add(section);
		course.setSections(sections);
		return course;
		
	}

	public Course setAuthorForCourse(Faculty faculty, Course course) {
		course.setAuthor(faculty);
		return course;
		
	}
	
	public Boolean enrollStudentInSection(Student student, Section section) {
		if(section.getSeats()>0) {
			List<Student> enrolled = section.getEnrolledStudents();
			if(enrolled == null)
				enrolled = new ArrayList<>();
			enrolled.add(student);
			section.setEnrolledStudents(enrolled);
			
			section.setSeats(section.getSeats()-1);
			sectionRepository.save(section);
			return true;
		}
		return false;	
	}
	
	public List<Person> findAllUsers() {
		return (List<Person>) personRepository.findAll();
	}
	
	public List<Student> findAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
	
	public List<Faculty> findAllFaculties() {
		return (List<Faculty>) facultyRepository.findAll();
	}
	
	@Autowired
	CourseRepository courseRepository;
	public List<Course> findAllCourses() {
		return (List<Course>) courseRepository.findAll();
	}
	
	public List<Section> findAllSections() {
		return (List<Section>) sectionRepository.findAll();
	}
	
	public List<Course> findCoursesForAuthor(Faculty faculty){
		return faculty.getAuthoredCourses();
	}
	
	public List<Section> findSectionForCourse(Course course){
		return course.getSections();
	}
	public List<Student> findStudentsInSection(Section section){
		return section.getEnrolledStudents();
	}

	public List<Section> findSectionsForStudent(Student student) {
		return student.getEnrolledSections();
	}
	

}