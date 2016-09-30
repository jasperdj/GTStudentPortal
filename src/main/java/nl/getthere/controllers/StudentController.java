package nl.getthere.controllers;

import javax.validation.Valid;

import nl.getthere.helpers.CurrentUser;
import nl.getthere.model.EducationRepository;
import nl.getthere.model.Student;
import nl.getthere.model.StudentRepository;
import nl.getthere.model.UniversityRepository;
import nl.getthere.model.User;
import nl.getthere.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private UniversityRepository universityRepo;
	@Autowired
	private EducationRepository educationRepo;
	@Autowired
	private UserRepository userRepo;

	@ModelAttribute("student")
	public Student getStudent(){
		return new Student();
	}
	
	@RequestMapping("/")
	public String goHome(){
		return "index";
	}
	
	@RequestMapping("/students")
	public String showStudents(Model model){
		model.addAttribute("students", studentRepo.findAll());
		return "studentsoverview";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String showForm(Model model){
		model.addAttribute("status", "Gebruik het formulier om een student aan te maken.");
		model.addAttribute("universities", universityRepo.findAll());
		model.addAttribute("educations", educationRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String createStudent(Model model, @Valid Student student, BindingResult result) {
		if(result.hasErrors()){
			model.addAttribute("error", "Student kon niet worden aangemaakt!");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "studentform";
		}
		try{
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
		}
		
		model.addAttribute("universities", universityRepo.findAll());
		model.addAttribute("educations", educationRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping("/detail")
	public String showStudentDetail(Model model){
		User u = userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail());		
		model.addAttribute("student", u.getStudent());
		model.addAttribute("universities", universityRepo.findAll());
		model.addAttribute("educations", educationRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public String editStudentDetail(Model model, @ModelAttribute @Valid Student student, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("error", "Student kon niet worden aangepast!");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "studentform";
		}
//		User u = userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail());
//		Student s = u.getStudent();
		try{
			studentRepo.save(student);
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
		}
		model.addAttribute("status", "Student gewijzigd!");
		model.addAttribute("students", studentRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public String showStudent(@PathVariable Long id, Model model){
		model.addAttribute("student", studentRepo.findOne(id));
		model.addAttribute("universities", universityRepo.findAll());
		model.addAttribute("educations", educationRepo.findAll());
		return "studentform";
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
	public String updateStudent(@PathVariable Long id, Model model, @Valid Student student, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("error", "Student kon niet worden aangepast!");
			model.addAttribute("universities", universityRepo.findAll());
			model.addAttribute("educations", educationRepo.findAll());
			return "studentform";
		}
		try{
			studentRepo.save(student);
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
		}
		model.addAttribute("status", "Student gewijzigd!");
		model.addAttribute("students", studentRepo.findAll());
		return "redirect:/students";
	}	
	
}
