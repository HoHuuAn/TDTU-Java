package com.hohuuan.Exercise4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exercise4Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise4Application.class, args);
	}

	private final StudentRepository database;
	public Exercise4Application(StudentRepository database) {
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

			System.out.println("Find the list of students whose age is greater than or equal to 20");
			database.findByAgeIsGreaterThanEqual(20).forEach(System.out::println);
			System.out.println();

			System.out.println("Count students having 8.0 ielts: "+ database.countByIeltsScore(8.0) + " students\n");

			System.out.println("Find the list of students whose name contains the word 'A'");
			database.findByNameContainingIgnoreCase("A").forEach(System.out::println);
		};
	}
}
