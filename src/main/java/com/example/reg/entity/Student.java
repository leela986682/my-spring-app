package com.example.reg.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Student {
	
		private String name;
		
		@Id
		private String email;
		
		private String pass;
		
}
