package com.myjavablog;

import com.myjavablog.dao.DepartmentRepository;
import com.myjavablog.dao.StudentRepository;
import com.myjavablog.model.Department;
import com.myjavablog.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootJpaManyToOneDemoApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringbootJpaManyToOneDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Unidirectional Mapping
		Department department = new Department();
		department.setName("COMPUTER");
        departmentRepository.save(department);

		Student student = new Student();
		student.setDepartment(departmentRepository.findDepartmentByName("COMPUTER"));
		student.setName("Anup");
		student.setMobile(989911);
		Student student1 = new Student();
		student1.setDepartment(departmentRepository.findDepartmentByName("COMPUTER"));
		student1.setName("John");
		student1.setMobile(89774);
		studentRepository.saveAll(Arrays.asList(student,student1));

		//Get the list of students from department
		List<Student> studentList = studentRepository.findAll();

		for(Student s : studentList)
			System.out.println(s);

	}
}

