package nl.getthere.controllers;

import nl.getthere.helpers.CurrentUser;
import nl.getthere.model.User;
import nl.getthere.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import static nl.getthere.helpers.CurrentUser.getCurrentUser;


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