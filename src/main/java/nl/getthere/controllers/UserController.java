package nl.getthere.controllers;

import nl.getthere.model.User;
import nl.getthere.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

	@Autowired
	private UserRepository repo;

	//todo remove this when proper form is in place.
	@RequestMapping("/public/newuser")
	public String createUser(Model model, String firstName, String lastName, String email, String phone, String password, Boolean isRecruiter){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User u = new User(firstName,lastName, email, phone, passwordEncoder.encode(password));
		repo.save(u);
		model.addAttribute("user", u);
		return "usercreation";
	}

}
