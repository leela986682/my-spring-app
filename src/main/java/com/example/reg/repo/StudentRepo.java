package com.example.reg.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.reg.entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, String>{

	List<Student> findByName(String name);
	
	List<Student> findByEmail(String name);
	
	Student getByNameAndEmail(String name, String email);
}
