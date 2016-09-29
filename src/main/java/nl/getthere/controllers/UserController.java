package nl.getthere.controllers;

import nl.getthere.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping("/newuser")
	public String createUser(Model model, String firstName, String lastName, String email, String phone, String password, Boolean isRecruiter){
		User u = new User();
		u.setFirstName("Henk");
		u.setLastName("de Vries");
		repo.save(u);
		model.addAttribute("user", u);
		return "usercreation";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
		return new ModelAndView("login", "error", error);
	}

}
