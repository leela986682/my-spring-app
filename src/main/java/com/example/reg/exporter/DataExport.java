package com.example.reg.exporter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example.reg.entity.Student;
import com.example.reg.repo.StudentRepo;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class DataExport {
	
		StudentRepo repo;
		
		@PreDestroy
		public void writerMethod() {
			String filepath = "src/main/resources/data.sql";
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,false))){
				writer.write("");
				System.err.println("method called");
				List<Student> list = repo.findAll();
				for(Student student :list) {
					String query = String.format("INSERT INTO student (email, name, pass) VALUES ('%s', '%s', '%s');\n",student.getEmail(),student.getName(),student.getPass());
					System.err.println(query);
					writer.write(query);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
