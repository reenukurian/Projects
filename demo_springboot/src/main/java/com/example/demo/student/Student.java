package com.example.demo.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table
public class Student {
private String name;
@Id
@SequenceGenerator(
	name="student_sequence",
	sequenceName="student_sequence",
	allocationSize=1
)
@GeneratedValue(
		strategy=GenerationType.SEQUENCE,
		generator="student_sequence"
		)
private Long id;
private Integer age;
private LocalDate dob;
private String email;
public Student(String name, Integer age, LocalDate dob, String email) {
	super();
	this.name = name;
	this.age = age;
	this.dob = dob;
	this.email = email;
}

public Student(String name, Long id, Integer age, LocalDate dob, String email) {
	super();
	this.name = name;
	this.id = id;
	this.age = age;
	this.dob = dob;
	this.email = email;
}
//getter setter
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Student() {
	
}

@Override
public String toString() {
	return "Student [name=" + name + ", id=" + id + ", age=" + age + ", dob=" + dob + ", email=" + email + "]";
}

}
