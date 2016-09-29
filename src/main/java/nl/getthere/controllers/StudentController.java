package nl.getthere.controllers;

import javax.validation.Valid;

import nl.getthere.model.EducationRepository;
import nl.getthere.model.Student;
import nl.getthere.model.StudentRepository;
import nl.getthere.model.UniversityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private UniversityRepository universityRepo;
	@Autowired
	private EducationRepository educationRepo;

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
		model.addAttribute("educations", educationRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String createStudent(Model model, @Valid Student student, BindingResult result) {
		if(result.hasErrors()){
			model.addAttribute("status", "Ja dat klopt niet, Harry.");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "studentform";
		}
		studentRepo.save(student);
		model.addAttribute("status", "Student aangemaakt!");
		model.addAttribute("universities", universityRepo.findAll());
		model.addAttribute("educations", educationRepo.findAll());
		return "studentform";
	}
	
	
	
	
}
