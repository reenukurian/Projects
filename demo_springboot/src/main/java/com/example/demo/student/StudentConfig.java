package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
@Bean
CommandLineRunner commandLineRunner(StudentRepository repository){
	return args->{
		Student REENU=new Student("Reenu",
				LocalDate.of(1996, Month.MARCH, 3),
				"reenu.kurian@gmail.com");
		Student Alex=new Student("Alex",
				LocalDate.of(1990, Month.MARCH, 3),
				"reenu.kurian@gmail.com");
		repository.saveAll(List.of(REENU,Alex));
	};
}
}
