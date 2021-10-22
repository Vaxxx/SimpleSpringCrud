package ng.com.createsoftware.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ng.com.createsoftware.entities.Student;
import ng.com.createsoftware.services.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	//handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "student";
	} 
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students" )
	public String saveStudent(@ModelAttribute("student")Student student) {
		 studentService.saveStudent(student);
		 return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student")Student student, Model model) {
		  ///get student from db by id
		Student stud = studentService.getStudentById(id);
		stud.setId(id);
		stud.setFirstName(student.getFirstName());
		stud.setLastName(student.getLastName());
		stud.setEmail(student.getEmail());
		
		//save update student object
		studentService.updateStudent(stud);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String destroy(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		 return "redirect:/students";
	}
}
