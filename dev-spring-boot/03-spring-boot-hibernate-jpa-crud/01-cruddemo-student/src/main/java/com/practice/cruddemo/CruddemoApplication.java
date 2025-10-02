package com.practice.cruddemo;

import com.practice.cruddemo.dao.StudentDAO;
import com.practice.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
//   CommandLine runner application
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createMultipleStudent(studentDAO);
//			createStudent(studentDAO);

//			readStudent(studentDAO);
			
//			queryForStudents(studentDAO);

//			queryForStudentLastName(studentDAO);

//			UpdateStudent(studentDAO);
			
//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
			
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleted row count"+numRowsDeleted );
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student " + studentId);
		studentDAO.delete(studentId);
	}

	private void UpdateStudent(StudentDAO studentDAO) {
//		retrieve student based on student id:primary id
		int studentId = 1;
		System.out.println("Getting student with id:" + studentId);
		Student myStudent = studentDAO.findBytId(studentId);
//		change first name to "scooby"
		myStudent.setFirstName("Scooby");
//		update the student
		studentDAO.update(myStudent);
//		display the update student
		System.out.println("Updated student:" + myStudent);
	}

	private void queryForStudentLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Duck");
		// display the list of students
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
//		get a list a student
		List<Student> students = studentDAO.findAll();

//		display list of student
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daff@com");

		// save a student
		System.out.println("saving teh student object...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int savedID = tempStudent.getId();
		System.out.println("saving teh student object..." + savedID);

		// retrieve student based on the id:primary kay
		System.out.println("reading teh student object..."+savedID);
		Student student = studentDAO.findBytId(savedID);
		// display student
		System.out.println("reading teh student object..."+student);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		Student tempStudent1 = new Student("John","doe","John@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");

		// save the student object
		System.out.println("Saving the students..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
//		create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");


//		save the student object
		System.out.println("Saving student object ...");
		studentDAO.save(tempStudent);

//		display id of teh saved object
		System.out.println("Saved student id: "+tempStudent);

	}
}
