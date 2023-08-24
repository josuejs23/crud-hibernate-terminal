package com.josuejs23.cruddemoterminal;

import com.josuejs23.cruddemoterminal.dao.StudentDAO;
import com.josuejs23.cruddemoterminal.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoterminalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoterminalApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			// createStudent(studentDAO);
			// createMultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// getAllStudents(studentDAO);
			getAllStudentsByFirstName(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){

		Student student = new Student("Josue", "Zorrilla", "josue@mail.com");
		studentDAO.save(student);
		System.out.printf("Student %s with id %s was persisted.", student.getFirstName(), student.getId());
	}

	public void createMultipleStudent(StudentDAO studentDAO){
		Student student2 = new Student("Lili", "Zorrilla", "lili@mail.com");
		Student student3 = new Student("Juan", "Zorrilla", "juan@mail.com");
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("student2 = " + student2);
		System.out.println("student3 = " + student3);
	}

	public void readStudent(StudentDAO studentDAO){
		System.out.println(studentDAO.findById(100).getFirstName());
	}

	public void getAllStudents(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		for(Student student : students){
			System.out.println(student);
		}
	}

	public void getAllStudentsByFirstName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByFirstName("Josue");
		for(Student student : students){
			System.out.println(student);
		}
	}

}
