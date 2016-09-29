package nl.getthere.controllers;

import javax.validation.Valid;

import nl.getthere.model.Student;
import nl.getthere.model.StudentRepository;
import nl.getthere.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private StudentRepository studentRepo;
	
	@ModelAttribute("student")
	public Student getStudent(){
		return new Student();
	}
	
	@RequestMapping("/registration")
	public String showRegistrationForm(){
		return "studentform";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerNewStudent(Model model, @Valid Student student, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("error", "Er is iets fout gegaan, probeer het opnieuw.");
			return "studentform";
		}
		
		
		return "redirect:/login";
	}
		
	
}
