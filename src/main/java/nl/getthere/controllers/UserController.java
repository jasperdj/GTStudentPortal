package nl.getthere.controllers;

import nl.getthere.models.User;
import nl.getthere.models.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	

}
