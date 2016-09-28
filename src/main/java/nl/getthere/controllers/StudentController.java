package nl.getthere.controllers;

import nl.getthere.model.Student;
import nl.getthere.model.StudentRepository;
import nl.getthere.model.UniversityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private UniversityRepository universityRepo;

	@ModelAttribute("student")
	public Student getStudent(){
		return new Student();
	}
	
	@RequestMapping("/")
	public String goHome(){
		return "index";
	}
	
	@RequestMapping("/students")
	public String showStudents(Model model){
		model.addAttribute("students", studentRepo.findAll());
		return "studentsoverview";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String showForm(Model model){
		model.addAttribute("status", "Gebruik het formulier om een student aan te maken.");
		model.addAttribute("universities", universityRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String createStudent(Model model, Student student) {
		studentRepo.save(student);
		model.addAttribute("status", "Student aangemaakt!");
		return "studentform";
	}
	
	
	
	
}
