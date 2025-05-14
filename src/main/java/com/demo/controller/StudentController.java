package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.StudentDto;
import com.demo.entity.Registration;
import com.demo.entity.Student;
import com.demo.service.StudentService;
import java.util.List;

// I can develop rest API

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service; 
	
	
	@PostMapping("/create")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto dto) {
//		System.out.println(student.getId());
//		System.out.println(student.getName());
//		System.out.println(student.getEmail());
//		System.out.println(student.getCourse());
//		System.out.println(service);
		
		StudentDto savedEntity=service.createStudent(dto);
//		savedEntity.setMessage("Record is saved!!");
		
		return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(@RequestParam long id) {
		service.deleteStudent(id);
		
		return new ResponseEntity<>("Record Deleted!!", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto dto){
		StudentDto savedEntity=service.updateStudent(dto);
		
		return new ResponseEntity<>(savedEntity, HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<StudentDto>> getAllStudent(){
		List<StudentDto> dtos=service.getAllStudent();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
		
	}
	
//	@PostMapping("/done")
//	public String createRegistration(@RequestBody Registration registration) {
//		System.out.println(registration.getEmail());
//		System.out.println(registration.getId());
//		System.out.println(registration.getName());
//		System.out.println(registration.getMobile());
//		
//		return "done";
//	}
}