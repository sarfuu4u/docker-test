package com.demo.service;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.StudentDto;
import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	// Database operation --> Service/Model layer
	
	//1. Create Repository layer in springboot to perform database
	// operation on entity class object
	// Repo layer gives us utility method like--
	// a. save() - Entity object will be saved in database
	// b. deleteById(id) - we can delete data from database
	// c. findById(id) - search the record based on id number
	// d. findAll() - will read all data from database
	
	@Autowired
	private StudentRepository repo;
	
	public StudentDto createStudent(StudentDto dto) {
		Student s=new Student();
//		s.setId(dto.getId());
//		s.setCourse(dto.getCourse());
//		s.setEmail(dto.getEmail());
//		s.setName(dto.getName());
		
		BeanUtils.copyProperties(dto, s);  // Its copy data from source to destination we don't need to do setId and getId
		
		Student savedEntity=repo.save(s);
		
		BeanUtils.copyProperties(savedEntity, dto);
		return dto;
		
	}

	public void deleteStudent(long id) {
		repo.deleteById(id);
		
	}

	public StudentDto updateStudent(StudentDto dto) {
		Student s =new Student();
		BeanUtils.copyProperties(dto, s);
		repo.save(s);
		
		BeanUtils.copyProperties(s, dto);
		return dto;
	}

	public List<StudentDto> getAllStudent() {
		List<StudentDto> dto=new ArrayList<>();
		
		Iterable<Student> students=repo.findAll();
		for(Student student:students) {
			StudentDto studentDto=new StudentDto();
			BeanUtils.copyProperties(student, studentDto);
			dto.add(studentDto);
		}
		return dto;
	}
	
}
