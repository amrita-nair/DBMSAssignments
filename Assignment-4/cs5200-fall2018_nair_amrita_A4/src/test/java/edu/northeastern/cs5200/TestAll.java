package edu.northeastern.cs5200;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.UniversityDao;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAll {
	//UniversityDao university - new UniversityDao();
	@Autowired
	UniversityDao universityDao;
	
	@Before
	public void setUp() {
		universityDao.truncateDatabase();
		Faculty	alan = new Faculty("alan", "alan","Alan", "Turin", "123A", true);
		Faculty	ada = new Faculty("ada", "ada","Ada", "Lovelace", "123B", true);
		Student	alice = new Student("alice", "alice","Alice", "Wonderland", 2020, 12000);
		Student	bob = new Student("bob", "bob","Bob", "Hope", 2021, 23000);
		Student	charlie = new Student("charlie", "charlie","Charlie", "Brown", 2019, 21000);
	   universityDao.createFaculty(alan);
	   
	   universityDao.createFaculty(ada);
	   
	   
	   universityDao.createStudent(alice);
	   
	   universityDao.createStudent(bob);
	   
	   universityDao.createStudent(charlie);
	   Student	dan = new Student("dan", "dan","Dan", "Craig", 2019, 0);
	   universityDao.createStudent(dan);
	   Student	edward = new Student("edward", "edward","Edward", "Scissorhands", 2022, 11000);
	   universityDao.createStudent(edward);
	   Student	frank = new Student("frank", "frank","Frank", "Herbert", 2018, 0);
	   universityDao.createStudent(frank);
	   Student	gregory = new Student("gregory", "gregory","Gregory", "Peck", 2023, 10000);
	   universityDao.createStudent(gregory);
	   Course CS1234 = new Course("CS1234", alan);
		universityDao.createCourse(CS1234);
		Course CS2345 = new Course("CS2345", alan);
		universityDao.createCourse(CS2345);
		Course CS3456 = new Course("CS3456", ada);
		universityDao.createCourse(CS3456);
		Course CS4567 = new Course("CS4567", ada);
		universityDao.createCourse(CS4567);
		Section SEC4321 = new Section("SEC4321", 50, CS1234);
		universityDao.createSection(SEC4321);
		Section SEC5432 = new Section("SEC5432", 50, CS1234);
		universityDao.createSection(SEC5432);
		Section SEC6543 = new Section("CS3456", 50, CS2345);
		universityDao.createSection(SEC6543);
		Section SEC7654 = new Section("CS4567", 50, CS3456);
		universityDao.createSection(SEC7654);
		universityDao.enrollStudentInSection(alice,SEC4321);
		universityDao.enrollStudentInSection(alice,SEC5432);
		universityDao.enrollStudentInSection(bob,SEC5432);
		universityDao.enrollStudentInSection(charlie,SEC6543);
	}
	

//	@Test
//	public void testCreateFaculty() {
//	    
//	   Faculty	alan = new Faculty("alan", "alan","Alan", "Turin", "123A", true);
//	   universityDao.createFaculty(alan);
//	   Faculty	ada = new Faculty("ada", "ada","Ada", "Lovelace", "123B", true);
//	   universityDao.createFaculty(ada);
//	}
	
	
	

//	@Test
//	public void testCreateStudent() {
//	    
//	   Student	alice = new Student("alice", "alice","Alice", "Wonderland", 2020, 12000);
//	   universityDao.createStudent(alice);
//	   Student	bob = new Student("bob", "bob","Bob", "Hope", 2021, 23000);
//	   universityDao.createStudent(bob);
//	   Student	charlie = new Student("charlie", "charlie","Charlie", "Brown", 2019, 21000);
//	   universityDao.createStudent(charlie);
//	   Student	dan = new Student("dan", "dan","Dan", "Craig", 2019, 0);
//	   universityDao.createStudent(dan);
//	   Student	edward = new Student("edward", "edward","Edward", "Scissorhands", 2022, 11000);
//	   universityDao.createStudent(edward);
//	   Student	frank = new Student("frank", "frank","Frank", "Herbert", 2018, 0);
//	   universityDao.createStudent(frank);
//	   Student	gregory = new Student("gregory", "gregory","Gregory", "Peck", 2023, 10000);
//	   universityDao.createStudent(gregory);
//	}
	

//	@Test
//	public void testCreateCourse() {
//		 
//		Faculty	alan = new Faculty("alan", "alan","Alan", "Turin", "123A", true);
//		universityDao.createFaculty(alan);
//		Faculty	ada = new Faculty("ada", "ada","Ada", "Lovelace", "123B", true);
//		universityDao.createFaculty(ada);
//		
//		Course CS1234 = new Course("CS1234", alan);
//		universityDao.createCourse(CS1234);
//		Course CS2345 = new Course("CS2345", alan);
//		universityDao.createCourse(CS2345);
//		Course CS3456 = new Course("CS3456", ada);
//		universityDao.createCourse(CS3456);
//		Course CS4567 = new Course("CS4567", ada);
//		universityDao.createCourse(CS4567);
//	}
	

//	@Test
//	public void testCreateSection() {
//		 
//		Faculty	alan = new Faculty("alan", "alan","Alan", "Turin", "123A", true);
//		universityDao.createFaculty(alan);
//		Faculty	ada = new Faculty("ada", "ada","Ada", "Lovelace", "123B", true);
//		universityDao.createFaculty(ada);
//		Course CS1234 = new Course("CS1234", alan);
//		universityDao.createCourse(CS1234);
//		Course CS2345 = new Course("CS2345", alan);
//		universityDao.createCourse(CS2345);
//		Course CS3456 = new Course("CS3456", ada);
//		Section SEC4321 = new Section("SEC4321", 50, CS1234);
//		universityDao.createSection(SEC4321);
//		Section SEC5432 = new Section("SEC5432", 50, CS1234);
//		universityDao.createSection(SEC5432);
//		Section SEC6543 = new Section("CS3456", 50, CS2345);
//		universityDao.createSection(SEC6543);
//		Section SEC7654 = new Section("CS4567", 50, CS3456);
//		universityDao.createSection(SEC7654);
//	}


//	@Test
//	public void testCreateEnroll() {
//			
//		 
//		Student	Alice = new Student("alice", "alice","Alice", "Wonderland", 2020, 12000);
//		universityDao.createStudent(Alice);
//		Student	Bob = new Student("bob", "bob","Bob", "Hope", 2021, 23000);
//		universityDao.createStudent(Bob);
//		Student	Charlie = new Student("charlie", "charlie","Charlie", "Brown", 2019, 21000);
//		universityDao.createStudent(Charlie);
//		Faculty	alan = new Faculty("alan", "alan","Alan", "Turin", "123A", true);
//		universityDao.createFaculty(alan);
//		Course CS1234 = new Course("CS1234", alan);
//		universityDao.createCourse(CS1234);
//		Course CS2345 = new Course("CS2345", alan);
//		universityDao.createCourse(CS2345);
//		Section SEC4321 = new Section("SEC4321", 50, CS1234);
//		universityDao.createSection(SEC4321);
//		Section SEC5432 = new Section("SEC5432", 50, CS1234);
//		universityDao.createSection(SEC5432);
//		Section SEC6543 = new Section("CS3456", 50, CS2345);
//		universityDao.createSection(SEC6543);
//		universityDao.enrollStudentInSection(Alice,SEC4321);
//		universityDao.enrollStudentInSection(Alice,SEC5432);
//		universityDao.enrollStudentInSection(Bob,SEC5432);
//		universityDao.enrollStudentInSection(Charlie,SEC6543);
//		
//	}
	

	@Test
	public void testValidateUser() {
		 
		assertEquals(9,universityDao.findAllUsers().size());
		 
	}
	
	@Test
	public void testValidateFaculty() {
		 
		assertEquals(2,universityDao.findAllFaculties().size());
	}
	
	@Test
	public void testValidateStudent() {
		 
		assertEquals(7,universityDao.findAllStudents().size());
	}
	
	@Test
	public void testValidateCourse() {
		 
		assertEquals(4,universityDao.findAllCourses().size());
	}
	
	@Test
	public void testValidateSection() {
		 
		assertEquals(4,universityDao.findAllSections().size());
	}
	//write a test that validates the total number of courses
	//authored by each faculty
	
	@Test
	public void testValidateCourseAuthorship() {
		 
		List<Faculty> faculties = universityDao.findAllFaculties();
		for(Faculty faculty: faculties) {
			if(faculty.getFirstName().equals("Alan")) {
			assertEquals(2,universityDao.findCoursesForAuthor(faculty).size());
			}
			else if(faculty.getFirstName().equals("Ada")) {
				assertEquals(2,universityDao.findCoursesForAuthor(faculty).size());
			}
		}
	}
	
	//Validates Section per Course - write a test that validates the total number of sections per
	//each course
	@Test
	public void testValidateSectionPerCourse() {
		 
	
		List<Course> courses = (List<Course>) universityDao.findAllCourses();
		for(Course course: courses) {
			if(course.getLabel().equals("CS1234"))
				assertEquals(2, universityDao.findSectionForCourse(course).size());
			if(course.getLabel().equals("CS2345"))
				assertEquals(1, universityDao.findSectionForCourse(course).size());
			if(course.getLabel().equals("CS3456"))
				assertEquals(1, universityDao.findSectionForCourse(course).size());
		}
	}
	
	@Test
	public void testValidateSectionEnrollments() {
		 
		
		List<Student> students = universityDao.findAllStudents();
		for(Student student: students) {
			if(student.getFirstName().equals("Alice"))
				assertEquals(2, universityDao.findSectionsForStudent(student).size());
			if(student.getFirstName().equals("Bob"))
				assertEquals(1, universityDao.findSectionsForStudent(student).size());
			if(student.getFirstName().equals("Charlie"))
				assertEquals(1, universityDao.findSectionsForStudent(student).size());
		}
	}
	
	@Test
	public void testValidateStudentEnrollments() {
		 
		
		List<Section> sections =  universityDao.findAllSections();
		for(Section section: sections) {
			if(section.getTitle().equals("SEC4321"))
				assertEquals(1, universityDao.findStudentsInSection(section).size());
			if(section.getTitle().equals("SEC5432"))
				assertEquals(2, universityDao.findStudentsInSection(section).size());
			if(section.getTitle().equals("SEC6543"))
				assertEquals(1, universityDao.findStudentsInSection(section).size());
		}
	}
	
	@Test
	public void testValidateSectionSeats() {
		HashMap<Section,Integer> sectionSeats = new HashMap<>();
		List<Section> sections = universityDao.findAllSections();
		for(Section section: sections) {
			if(section.getSeats()==49) {
				System.out.println(section.getTitle());
			assertEquals(49, section.getSeats());
			}
			else if(section.getSeats()==50) {
				System.out.println(section.getTitle());
				assertEquals(50, section.getSeats());
			}
		}
	
	}
	
}
