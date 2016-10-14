package nl.getthere.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import nl.getthere.model.Event;
import nl.getthere.model.Student;
import nl.getthere.model.User;
import nl.getthere.model.respositories.EventRepository;
import nl.getthere.model.respositories.StudentRepository;
import nl.getthere.model.respositories.UserRepository;
import nl.getthere.services.PortalMailService;

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
	private EventRepository eventRepo;
	@Autowired
	private PortalMailService mailService;
	
	@ModelAttribute("student")
	public Student getStudent(){
		return new Student();
	}
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}

	@RequestMapping("/api/maildebug")
	public String sendWelcomeMail(){
		User user = new User();
		user.setFirstName("Ruud");
		user.setEmail("ruudzonnenberg@gmail.com");
		mailService.sendWelcomeMail(user);
		return "registration";
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
			boolean sentSucces = mailService.sendWelcomeMail(user);
			String statusMsg = sentSucces ? "Er is een mail verstuurd naar: " + user.getEmail() : "Fout tijdens het versturen van de welkoms-email." ;

			model.addAttribute("status", statusMsg);
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
			e.printStackTrace();
			return "registration";
		}
		
		return "redirect:/login";
	}

	@RequestMapping("/registration/event/{id}")
	public String showRegistrationForEvent(Model model, @PathVariable Long id){
		Event e = eventRepo.findOne(id);
		if(e == null){
			return "404";
		}

		model.addAttribute("event", e);
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
			if(event.getAttendees() == null){
				event.setAttendees(new ArrayList<User>());
			}
			event.getAttendees().add(user);
			
			if(user.getEventsAttending() == null){
				user.setEventsAttending(new ArrayList<Event>());
			}
			user.getEventsAttending().add(event);
			userRepo.save(user);
			eventRepo.save(event);
		}catch(Exception e){
			model.addAttribute("error", e);
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
