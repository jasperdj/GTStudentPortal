package nl.getthere.controllers;

import java.util.List;

import javax.validation.Valid;

import nl.getthere.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValidationController {
	
	@RequestMapping(value = "/jvalid", method = RequestMethod.POST)
	public @ResponseBody List<ObjectError> isValid(@Valid User user, BindingResult result){
		return result.getAllErrors();
	}
	
	@RequestMapping("/ajaxtest")
	public String showDebugAjax(){
		return "ajaxtest";
	}

}
