package com.example.reg.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.reg.entity.Student;
import com.example.reg.exporter.DataExport;
import com.example.reg.repo.StudentRepo;

import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;

@Controller
@ResponseBody
@CrossOrigin("*")
@RequestMapping("/form")
@AllArgsConstructor
public class StudentController {
	
		StudentRepo repo;
		
		DataExport export;
		
		@PostMapping("/set")
		public ResponseEntity<String> postMethodName(@RequestBody Student data) {
			repo.save(data);
			return ResponseEntity.ok(data.getName()+" is registered successfully with "+data.getEmail());
		}
		
		@GetMapping("/get")
		public ResponseEntity<List<String>> getMethodName() {
			List<Student> students = repo.findAll();
			return ResponseEntity.ok(students.stream().map(s->s.getName()).toList());
		}
		
		@GetMapping("/get/object")
		public ResponseEntity<List<Student>> getMethod() {
			List<Student> students = repo.findAll();
			return ResponseEntity.ok(students);
		}
		
		@GetMapping("/getByName/{name}")
		public ResponseEntity<List<Student>> getMethodByName(@PathVariable String name) {
			List<Student> students = repo.findByName(name);
			return ResponseEntity.ok(students);
		}
		
		@GetMapping("/getByEmail/{email}")
		public ResponseEntity<List<Student>> getMethodByEmail(@PathVariable String email) {
			List<Student> students = repo.findByEmail(email);
			return ResponseEntity.ok(students);
		}
		
		@GetMapping("/get/{name}/{email}")
		public ResponseEntity<Student> getM(@PathVariable String name, @PathVariable String email ){
			Student student = repo.getByNameAndEmail(name,email);
			return ResponseEntity.ok(student);
		}
		
		@PreDestroy
		public void destroymethod() {
			 export.writerMethod();
		}
}
