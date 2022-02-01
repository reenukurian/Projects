package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	public List<Student> getStudents() {
		return List.of(new Student("Reenu",
				1L,25,LocalDate.of(1996, Month.MARCH, 3),"reenu.kurian@gmail.com"));
	}
}
