package nl.getthere.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import nl.getthere.model.Event;
import nl.getthere.model.Student;
import nl.getthere.model.User;
import nl.getthere.model.respositories.EventRespository;
import nl.getthere.model.respositories.StudentRepository;
import nl.getthere.model.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private EventRespository eventRepo;
	
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
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerNewStudent(@Valid User user, BindingResult result, Model model ){
		if(result.hasErrors()){
			model.addAttribute("error", "Er is iets fout gegaan, probeer het opnieuw.");
			return "registration";
		}
		try{
			StudentController.createStudent(studentRepo, userRepo, model, user);
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
			e.printStackTrace();
			return "registration";
		}
			
		return "redirect:/login";
	}

	@RequestMapping("/registration/event/{id}")
	public String showRegistrationForEvent(Model model, @PathVariable Long id){
		try{
			Event e = eventRepo.findOne(id);
			model.addAttribute("event", e);
			return "registration";
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return "registration";
	}
	
	@RequestMapping(value = "/registration/event/{id}", method = RequestMethod.POST)
	public String registerForEvent(@Valid User user, @PathVariable Long id, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("error", "Er is iets fout gegaan, probeer het opnieuw.");
			return "registration";
		}
		try{
			StudentController.createStudent(studentRepo, userRepo, model, user);
			// TODO: create dedicated function for this.
			user = userRepo.findOneByEmail(user.getEmail());
			Event event = eventRepo.findOne(id);
			if(event.getAttendiesAccepted().isEmpty()){
				event.setAttendiesAccepted(new ArrayList<User>());
			}
			event.getAttendiesAccepted().add(user);
			eventRepo.save(event);
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
			e.printStackTrace();
			return "registration";
		}
			
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
		return new ModelAndView("login", "error", error);
	}
	
}
