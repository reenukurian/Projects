package com.example.demo.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long Id) {
		studentService.deleteStudent(Id);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudnet(@PathVariable("studentId") Long Id,
							@RequestParam(required = false) String name,
							@RequestParam(required = false) String email) {
		System.out.println("isnide update api");
		studentService.updateStudent(Id,email,name);
		
	}
}
