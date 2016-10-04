package nl.getthere.controllers;

import javax.validation.Valid;

import nl.getthere.model.respositories.EducationRepository;
import nl.getthere.model.Student;
import nl.getthere.model.respositories.StudentRepository;
import nl.getthere.model.respositories.UniversityRepository;
import nl.getthere.model.User;
import nl.getthere.model.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
	
	@RequestMapping("/registration")
	public String showRegistrationForm(Model model){
		model.addAttribute("universities", universityRepo.findAll());
		model.addAttribute("educations", educationRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerNewStudent(Model model, @Valid Student student, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("error", "Er is iets fout gegaan, probeer het opnieuw.");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "studentform";
		}
		try{
			//todo redundant block of code with StudentController
			User user = new User();
			user.setFirstName(student.getFirstName());
			user.setLastName(student.getLastName());
			user.setEmail(student.getEmail());
			user.setPassword(new BCryptPasswordEncoder().encode("student"));
			user.setUserRole("student");
				
			studentRepo.save(student);
			user.setStudent(student);
			userRepo.save(user);
			model.addAttribute("status", "Student aangemaakt!");
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "studentform";
		}
			
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
		return new ModelAndView("login", "error", error);
	}
	
}
