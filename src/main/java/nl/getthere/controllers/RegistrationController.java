package nl.getthere.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import nl.getthere.model.EducationRepository;
import nl.getthere.model.Student;
import nl.getthere.model.StudentRepository;
import nl.getthere.model.UniversityRepository;
import nl.getthere.model.User;
import nl.getthere.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private UniversityRepository universityRepo;
	@Autowired
	private EducationRepository educationRepo;
	
	@ModelAttribute("student")
	public Student getStudent(){
		return new Student();
	}
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	@RequestMapping("/registration")
	public String showRegistrationForm(Model model){
		model.addAttribute("universities", universityRepo.findAll());
		model.addAttribute("educations", educationRepo.findAll());
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerNewStudent(@Valid User user, BindingResult result, String password, Model model ){
		if(result.hasErrors()){
			model.addAttribute("error", "Er is iets fout gegaan, probeer het opnieuw.");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "registration";
		}
		if(password.length() < 8){
			model.addAttribute("error", "Wachtwoord is te kort (min. 8 tekens).");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "registration";
		}
		try{
			Student student = new Student();
			student.setFirstName(user.getFirstName());
			student.setLastName(user.getLastName());
			student.setEmail(user.getEmail());
			student.setDateJoined(LocalDate.now());
			studentRepo.save(student);
			
			user.setUserRole("student");
			user.setStudent(student);
			userRepo.save(user);
			model.addAttribute("status", "Student aangemaakt!");
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			e.printStackTrace();
			return "registration";
		}
			
		return "redirect:/login";
	}
		
	
}
