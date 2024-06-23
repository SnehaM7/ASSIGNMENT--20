package com.app.studentapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.studentapi.model.Student;
import com.app.studentapi.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Optional<Student> findById(long id) {
		Optional<Student> op = studentRepository.findById(id);
		return op;
	}
	
	public void remove(long id) {
		studentRepository.deleteById(id);
	}
	
	public long countAll() {
		return studentRepository.count();
	}

	
	
	
}
