package com.app.studentapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.studentapi.constants.ResponseKey;
import com.app.studentapi.constants.ResponseMessage;
import com.app.studentapi.model.Student;
import com.app.studentapi.service.StudentService;


@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		try {
				List<Student> studentsList = studentService.findAll();
				return new ResponseEntity<>(studentsList, HttpStatus.OK);
		} catch (Exception e) {
			HashMap< String, String> data = new HashMap<>();
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Student student) {
		HashMap< String, String> data = new HashMap<>();
		try {
			Student savedStudent = studentService.save(student);
			data.put(ResponseKey.MESSAGE, ResponseMessage.STUDENT_INSERTED);
			return new ResponseEntity<>(data,HttpStatus.OK);
		} catch (Exception e) {
			
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		HashMap< Object, Object> data = new HashMap<>();
		try {
			Optional<Student> studentOptional = studentService.findById(id);
			if(studentOptional.isPresent()) {
				Student student = studentOptional.get();
				return new ResponseEntity<>(student,HttpStatus.OK);
			}
			else {
				data.put(ResponseKey.MESSAGE, ResponseMessage.STUDENT_NOT_FOUND);
				return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable int id){
		HashMap< Object, Object> data = new HashMap<>();
		try {
			Optional<Student> studentOptional = studentService.findById(id);
			if(studentOptional.isPresent()) {
				studentService.remove(id);
				data.put(ResponseKey.MESSAGE, ResponseMessage.STUDENT_REMOVED);
				return new ResponseEntity<>(data,HttpStatus.OK);
			}
			else {
				data.put(ResponseKey.MESSAGE, ResponseMessage.STUDENT_NOT_FOUND);
				return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
