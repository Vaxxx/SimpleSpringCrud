package ng.com.createsoftware.services;

import java.util.List;

import ng.com.createsoftware.entities.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}


