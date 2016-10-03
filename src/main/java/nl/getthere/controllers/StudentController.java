package nl.getthere.controllers;

import javax.validation.Valid;

import nl.getthere.helpers.CurrentUser;
import nl.getthere.model.Education;
import nl.getthere.model.EducationRepository;
import nl.getthere.model.Student;
import nl.getthere.model.StudentRepository;
import nl.getthere.model.University;
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
import org.springframework.web.bind.support.SessionStatus;

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
	
	@ModelAttribute("newStudent")
	public Student getNewStudent(){
		return new Student();
	}
	
	@ModelAttribute("universities")
	public Iterable<University> getUniversity(){
		return universityRepo.findAll();
	}
	
	@ModelAttribute("educations")
	public Iterable<Education> getEducation(){
		return educationRepo.findAll();
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
	
	@RequestMapping("/student")
	public String showForm(SessionStatus status){
		return "newstudent";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String createStudent(Model model, @Valid Student newStudent, BindingResult result) {
		if(result.hasErrors()){
			model.addAttribute("error", "Student kon niet worden aangemaakt!");
			return "newstudent";
		}
		try{
			User user = new User();
			user.setFirstName(newStudent.getFirstName());
			user.setLastName(newStudent.getLastName());
			user.setEmail(newStudent.getEmail());
			user.setPassword(new BCryptPasswordEncoder().encode("student"));
			user.setUserRole("student");
				
			studentRepo.save(newStudent);
			user.setStudent(newStudent);
			userRepo.save(user);

			model.addAttribute("status", "Student aangemaakt!");
		}catch(Exception e){
			model.addAttribute("error", "Er bestaat al een account met dat e-mailadres!");
			e.printStackTrace();
		}
		
		return "newstudent";
	}
	
	@RequestMapping("/detail")
	public String showStudentDetail(Model model){
		User u = userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail());		
		model.addAttribute("student", u.getStudent());
		
		
		return "studentform";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public String editStudentDetail(Model model, @ModelAttribute @Valid Student student, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("error", "Student kon niet worden aangepast!");
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
		return "studentform";
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
	public String updateStudent(@PathVariable Long id, Model model, @Valid Student student, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("error", "Student kon niet worden aangepast!");
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
