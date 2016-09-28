package nl.getthere.controllers;

import java.time.LocalDate;

import nl.getthere.models.Education;
import nl.getthere.models.Student;
import nl.getthere.models.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository repo;

	@RequestMapping(value = "/newstudent", method = RequestMethod.POST)
	public String createStudent(Model model, @RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName, @RequestParam(required = true) String email,
			@RequestParam(required = false) String phone, @RequestParam(required = true) String password, @RequestParam(required = true) Education education, LocalDate startEducation, LocalDate endEducation,
			LocalDate dateOfBirth) {
		Student s = new Student(firstName, lastName, email, phone, password, LocalDate.now(), education, startEducation, endEducation, dateOfBirth);
		repo.save(s);
		model.addAttribute("status", "Student aangemaakt!");
		model.addAttribute("student", s);
		return "newstudent";
	}
	
	@RequestMapping(value = "/newstudent", method = RequestMethod.GET)
	public String showForm(Model model){
		model.addAttribute("status", "Gebruik het formulier om een student aan te maken.");
		return "newstudent";
	}

}
