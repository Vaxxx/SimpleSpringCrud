package ng.com.createsoftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ng.com.createsoftware.entities.Student;
import ng.com.createsoftware.repositories.StudentRepository;

@SpringBootApplication
public class StudentMsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentMsApplication.class, args);
	}
 
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student = new Student("Okagbare", "Vakpo", "vakporize@mail.com");
//		studentRepository.save(student);
	}

}
