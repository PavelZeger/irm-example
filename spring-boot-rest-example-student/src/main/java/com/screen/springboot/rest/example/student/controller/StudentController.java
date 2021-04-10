package com.screen.springboot.rest.example.student.controller;

import com.screen.springboot.rest.example.student.dao.Student;
import com.screen.springboot.rest.example.student.dao.StudentRepository;
import com.screen.springboot.rest.example.student.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	@GetMapping
	public List<Student> retrieveAllStudents() {
		List<Student> students = studentRepository.findAll();
		if (students.isEmpty()) {
			throw new StudentNotFoundException("Any student wasn't found");
		}
		return students;
	}

	@GetMapping("/{id}")
	public Student retrieveStudent(@PathVariable long id) {
		return studentRepository.findById(id).orElseThrow(() ->
				new StudentNotFoundException("The student with the id " + id + " wasn't found!"));
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}

	@PostMapping
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);
		URI location = getLocation(savedStudent, "/{id}");
		return ResponseEntity.created(location).build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
		Student updatedStudent = studentRepository.save(student);
		URI location = getLocation(updatedStudent, "/{id}");
		return ResponseEntity.created(location).build();
	}

	private URI getLocation(Student student, String path) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(path)
				.buildAndExpand(student.getId()).toUri();
	}

}
