package nl.getthere.controllers;

import nl.getthere.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	

}
