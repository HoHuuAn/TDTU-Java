package com.hohuuan.Exercise3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exercise3Application {
	public static void main(String[] args) {
		SpringApplication.run(Exercise3Application.class, args);
	}

	private final StudentRepository database;
	public Exercise3Application(StudentRepository database) {
		this.database = database;
	}

	@Bean
	public CommandLineRunner program(){
		return args -> {
			Student s1 = new Student(0, "Andy", 20, "andy@gmail.com", 6.5);
			Student s2 = new Student(1, "Bob", 21, "bob@gmail.com", 8.0);
			Student s3 = new Student(2, "Cathy", 19, "cathy@gmail.com", 7.5);
			Student s4 = new Student(3, "David", 22, "david@gmail.com", 7.5);
			Student s5 = new Student(4, "Emily", 20, "emily@gmail.com", 8.5);
			Student s6 = new Student(5, "Frank", 21, "frank@gmail.com", 6.5);
			Student s7 = new Student(6, "Grace", 19, "grace@gmail.com", 7.5);
			Student s8 = new Student(7, "Henry", 20, "henry@gmail.com", 8.0);
			Student s9 = new Student(8, "Isabella", 22, "isabella@gmail.com", 7.5);
			Student s10 = new Student(9, "Jack", 19, "jack@gmail.com", 8.5);
			Student s11 = new Student(10, "Kelly", 21, "kelly@gmail.com", 7.0);
			Student s12 = new Student(11, "Liam", 20, "liam@gmail.com", 8.2);
			Student s13 = new Student(12, "Megan", 19, "megan@gmail.com", 7.8);

			database.save(s1);
			database.save(s2);
			database.save(s3);
			database.save(s4);
			database.save(s5);
			database.save(s6);
			database.save(s7);
			database.save(s8);
			database.save(s9);
			database.save(s10);
			database.save(s11);
			database.save(s12);
			database.save(s13);

			//Read the student list and print it to the console
			System.out.println("The student list");
			database.findAll().forEach(System.out::println);
			System.out.println();

			//Update any student's information and print out the results after updating
			System.out.println("Before Update Student with ID = 1" + database.findById(1));
			s2.setName("Anthony");
			s2.setAge(40);
			s2.setEmail("anthony@gmail.com");
			database.save(s2);
			System.out.println("Before Update Student with ID = 1" + database.findById(1));
			System.out.println();

			//Delete a student from the database and print the result after deleting
			System.out.println("Before Delete Student with ID = 13");
			database.findAll().forEach(System.out::println);
			database.deleteById(12);
			System.out.println("After Delete Student with ID = 13");
			database.findAll().forEach(System.out::println);
		};
	}
}
