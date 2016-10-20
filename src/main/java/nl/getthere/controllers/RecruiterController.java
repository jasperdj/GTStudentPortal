package nl.getthere.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import nl.getthere.model.Education;
import nl.getthere.model.Event;
import nl.getthere.model.Student;
import nl.getthere.model.University;
import nl.getthere.model.User;
import nl.getthere.model.respositories.EducationRepository;
import nl.getthere.model.respositories.EventRepository;
import nl.getthere.model.respositories.StudentRepository;
import nl.getthere.model.respositories.UniversityRepository;
import nl.getthere.model.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RecruiterController {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private UniversityRepository universityRepo;
	
	@Autowired
	private EducationRepository educationRepo;

	@RequestMapping("recruiter/students")
	public String showStudents(){
		return "recruiterStudentOverview";
	}
	
	@RequestMapping("recruiterapi/students/")
	public @ResponseBody List<Student> getStudents() {
		List<Student> students = (List<Student>) studentRepo.findAll();
		return students;
	}

	@RequestMapping("recruiterapi/students/{studentid}/")
	public @ResponseBody Student getStudent(@PathVariable Long studentid) {
		Student student = studentRepo.findOne(studentid);
		return student;
	}
	
	@RequestMapping(value = "recruiterapi/students/{studentid}", method = RequestMethod.PUT)
	public @ResponseBody Student updateStudent(@PathVariable Long studentid, @RequestBody Student student) {
		Student s = studentRepo.findOne(studentid);
		User u = userRepo.findOneByEmail(s.getEmail());
		s.setFirstName(student.getFirstName());
		u.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		u.setLastName(student.getLastName());
		s.setEmail(student.getEmail());
		u.setEmail(student.getEmail());
		s.setPhone(student.getPhone());
		s.setDateOfBirth(student.getDateOfBirth());
		s.setEducation(student.getEducation());
		s.setStartEducation(student.getStartEducation());
		s.setEndEducation(student.getEndEducation());
		s.setContactOrigin(student.getContactOrigin());
		
		return studentRepo.save(s);
	}
	
	@RequestMapping(value = "recruiterapi/students/", method = RequestMethod.POST)
	public @ResponseBody Student createStudent(@RequestBody Student student) {
		if(student == null){
			return null;
		}
//		List<String> errors = validateStudent(student);
//		if(!errors.isEmpty()){
//			return null; //TODO Make sure these errors are sent back.
//		}
		User u = new User();
		u.setFirstName(student.getFirstName());
		u.setLastName(student.getLastName());
		u.setEmail(student.getEmail());
		u.setPassword("password");
		Long studentId = StudentController.createStudent(studentRepo, userRepo, u, student);
		if(studentId == 0){
			return null;
		}
		return studentRepo.findOne(studentId);
	}
	
	@RequestMapping(value = "recruiterapi/students/{studentid}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteStudent(@PathVariable Long studentid){
		try{
			Student s = studentRepo.findOne(studentid);
			if(s.getId() == null){
				return "404";
			}
			User u = userRepo.findOneByEmail(s.getEmail());
			userRepo.delete(u.getUserId());
			studentRepo.delete(studentid);
		}catch(Exception e){
			return e.getMessage();
		}
			
		return "200";
	}
		
	@RequestMapping("recruiter/events")
	public String showEvents(){
		return "recruiterEventOverview";
	}

	@RequestMapping("recruiterapi/universities/")
	public @ResponseBody List<University> getUniversities(){
		List<University> universities = (List<University>) universityRepo.findAll(); 
		return universities;
	}
	
	@RequestMapping("recruiterapi/educations/")
	public @ResponseBody List<Education> getEducations(){
		List<Education> educations = (List<Education>) educationRepo.findAll(); 
		return educations;
	}
	
	@ModelAttribute("event")
	public Event createEventBean() {
	        return new Event();
	}
	
	@ModelAttribute("newEvent")
	public Event createNewEventBean() {
	        return new Event();
	}
	
	@RequestMapping("recruiterapi/events/")
	public @ResponseBody List<Event> getEvents() {
		List<Event> events = (List<Event>) eventRepo.findAll();
		return events;
	}

	@RequestMapping("recruiter/events/{eventid}/")
	public String getEvent(@PathVariable Long eventid, Model model) {
		if(!eventRepo.exists(eventid)){
			return "404";
		}
		model.addAttribute("event", eventRepo.findOne(eventid));
		return "updateEvent";
	}

	@RequestMapping(value = "recruiter/events/{eventid}/", headers = "content-type=multipart/*", method = RequestMethod.POST)
	public String updateEvent(@PathVariable Long eventid, @ModelAttribute @Valid Event event, @RequestParam("image") MultipartFile image, BindingResult result) throws IOException {
		if(result.hasErrors()){
			return "updateEvent";
		}
		
		Event e = eventRepo.findOne(eventid);
		e.setTitle(event.getTitle());
		e.setDescription(event.getDescription());
		e.setImageUrl(processImage(image));
		e.setStart(event.getStart());
		e.setEnd(event.getEnd());
		e.setLocation(event.getLocation());
		e.setEventThemes(event.getEventThemes());
		e.setEventTypes(event.getEventTypes());
		e.setVacancy(event.getVacancy());
		
		try{
			eventRepo.save(e);
		}catch(Exception ex){
			System.out.println("ERROR IN UPDATEEVENT()");
			ex.printStackTrace();
		}
		
		return "redirect:/recruiter/events";
	}
	
    @RequestMapping(value = "recruiter/events/new", method = RequestMethod.GET)
    public String newEvent(Model model) {
        return "newEvent";
    }
	
	@RequestMapping(value = "recruiter/events/new", headers = "content-type=multipart/*", method = RequestMethod.POST)
	public String createEvent(@Valid Event newEvent, @RequestParam("image") MultipartFile image, BindingResult result) throws IOException {
		if(result.hasErrors()){
			return "newEvent";
		}
		if(newEvent == null){
			return "newEvent";
		}
		if(newEvent.getTitle() == null){
			return "newEvent";
		}

		newEvent.setImageUrl(processImage(image));
		
		eventRepo.save(newEvent);
		return "redirect:/recruiter/events";
	}
		
	@RequestMapping(value = "recruiterapi/events/{eventid}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteEvent(@PathVariable Long eventid){
		try{
			Event e = eventRepo.findOne(eventid);
			if(e.getEventId() == null){
				return "404";
			}
			eventRepo.delete(eventid);
		}catch(Exception e){
			return e.getMessage();
		}
			
		return "200";
	}

	
	// HELPERS
	
	private List<String> validateStudent(Student student){
		List<String> errors = new ArrayList<String>();
		
		if(student.getFirstName() == null){
			errors.add("Voer aub uw voornaam in.");
		}
		
		if(student.getLastName() == null){
			errors.add("Voer aub uw achternaam in.");
		}
		
		if(student.getEmail() == null){
			errors.add("Voer aub een geldig email adres in.");
		}else if(!isValidEmail(student.getEmail())){
			errors.add("Voer aub een geldig email adres in.");
		}
		
		if(student.getPhone() != null && student.getPhone().length() != 10){
			errors.add("Voer aub een geldig telefoonnummer in.");
		}
		
		
		return errors;
	}
	
	private boolean isValidEmail(String email){
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	private String processImage(MultipartFile image) throws IOException{
		Resource resource = new ClassPathResource("/application.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		String root = props.getProperty("event.image.location");

		Random randy = new Random();

		if (!image.isEmpty()) {
			String id = randy.nextInt(Integer.MAX_VALUE) + ".png";
			String filename = root + id ;
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
			File destination = new File(filename); 
			ImageIO.write(src, "png", destination);
			return id;
		}
		return "";
	}
}
