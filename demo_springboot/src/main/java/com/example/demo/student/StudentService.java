package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.lang.IllegalStateException;
@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	public List<Student> getStudents() {
		/*return List.of(new Student("Reenu",
				1L,25,LocalDate.of(1996, Month.MARCH, 3),"reenu.kurian@gmail.com"));*/
		
		return studentRepository.findAll();
	}
	
	
	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail=studentRepository.
				findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
		System.out.println(student);
		
	}
	public void deleteStudent(Long id) {
		Boolean studentExists=studentRepository.existsById(id);
		if(studentExists)
			studentRepository.deleteById(id);
		else
			throw new IllegalStateException("No user to delete");
		
	}
	@Transactional
	public void updateStudent(Long id,String name, String email) {
		// TODO Auto-generated method stub
		Student student=studentRepository.findById(id).
				orElseThrow(()->new IllegalStateException("No user to update"));
		if(name!=null && name.length()>0 && !Objects.equals(name, student.getName())) {
			System.out.println("inside update");
			student.setName(name);
		}
		
	}
}
