package nl.getthere.controllers;

import static java.time.LocalDate.now;

import javax.validation.Valid;

import nl.getthere.model.Education;
import nl.getthere.model.Student;
import nl.getthere.model.University;
import nl.getthere.model.User;
import nl.getthere.model.respositories.*;
import nl.getthere.security.CurrentUser;

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
	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private EventThemeRepository eventThemeRepo;

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
	public String goHome(Model model){
		model.addAttribute("eventThemes", eventThemeRepo.findAll());
		return "index";
	}
	
	@RequestMapping("/students")
	public String showStudents(Model model){
		model.addAttribute("students", studentRepo.findAll());
		return "studentsoverview";
	}

	@RequestMapping("/events/")
	public String getEventOverview(Model model) {
		try {
			User user = userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail());
			model.addAttribute("userId", user.getUserId());
		} catch(Exception e) {
			model.addAttribute("userId", -1);
		}

		return "eventOverview";
	}

	@RequestMapping("/events")
	public String rerouteEvents(Model model) {
		System.out.println("redirect completed.");
		return "redirect:/events/";
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
			createStudent(studentRepo, userRepo, model, newStudent);
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
				
		return "detail";
	}
	
	public static Long createStudent(StudentRepository studentRepo, UserRepository userRepo,  User user, Student student) {
		try{
			student.setFirstName(user.getFirstName());
			student.setLastName(user.getLastName());
			student.setEmail(user.getEmail());
			student.setDateJoined(now());

			Student s = studentRepo.save(student);

			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			user.setUserRole("student");
			user.setStudent(student);
			userRepo.save(user);
			return s.getId();
		}catch(Exception e){
			System.out.println("createStudent ERROR:" + e.getMessage());
		}
		return null;

	}

	public static void createStudent(StudentRepository studentRepo, UserRepository userRepo, Model model, User user) {
		Student student = new Student();
		student.setFirstName(user.getFirstName());
		student.setLastName(user.getLastName());
		student.setEmail(user.getEmail());
		student.setDateJoined(now());

		studentRepo.save(student);

		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setUserRole("student");
		user.setStudent(student);
		userRepo.save(user);

		model.addAttribute("status", "Student aangemaakt!");
	}

	public static void createStudent(StudentRepository studentRepo, UserRepository userRepo, Model model, Student newStudent) {
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
	}
	
	@RequestMapping("/editprofile")
	public String showStudentForm(Model model){
		User u = userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail());		
		model.addAttribute("student", u.getStudent());
				
		return "studentform";
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public String editStudentDetail(Model model, @ModelAttribute @Valid Student student, BindingResult result){
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
		return "studentform";
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public String showStudent(@PathVariable Long id, Model model){
		Student s = studentRepo.findOne(id);
		if(s == null){
			return "404";
		}
		model.addAttribute("student", s);
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
