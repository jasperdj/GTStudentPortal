package nl.getthere.controllers;

import java.io.IOException;
import java.util.List;

import nl.getthere.model.Event;
import nl.getthere.model.Student;
import nl.getthere.model.respositories.EventRepository;
import nl.getthere.model.respositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecruiterController {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private EventRepository eventRepo;

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

	@RequestMapping(value = "recruiterapi/students/{studentid}/", method = RequestMethod.PUT)
	public @ResponseBody Student updateStudent(@PathVariable Long studentid) {

		return null;
	}
	
	@RequestMapping(value = "recruiterapi/students/", method = RequestMethod.POST)
	public @ResponseBody Student createStudent() {

		return null;
	}
	
	@RequestMapping(value = "recruiterapi/students/{studentid}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteStudent(){
		
		return "";
	}
	
	
	@RequestMapping("recruiter/events")
	public String showEvents(){
		
		return "recruiterEventOverview";
	}
	
	@RequestMapping("recruiterapi/events/")
	public @ResponseBody List<Event> getEvents() {
		List<Event> events = (List<Event>) eventRepo.findAll();
		return events;
	}

	@RequestMapping("recruiterapi/events/{eventid}/")
	public @ResponseBody Event getEvent(@PathVariable Long eventid) {
		Event event = eventRepo.findOne(eventid);
		return event;
	}

	@RequestMapping(value = "recruiterapi/events/{eventid}/", method = RequestMethod.PUT)
	public @ResponseBody Event updateEvent(@PathVariable Long eventid) {

		return null;
	}
	
	@RequestMapping(value = "recruiterapi/events/", method = RequestMethod.POST,  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody Event createEvent(@RequestBody Event newEvent) throws IOException {
		if(newEvent == null){
			return null;
		}
		if(newEvent.getTitle() == null){
			return null;
		}
		
		System.out.println(newEvent.getImageUrl());
//		ADD TO PARAMETERS , @RequestParam("image") MultipartFile image		
//		Resource resource = new ClassPathResource("/application.properties");
//		Properties props = PropertiesLoaderUtils.loadProperties(resource);
//		String root = props.getProperty("event.image.location");
//
//		Random randy = new Random();
//
//		if (!image.isEmpty()) {
//			String id = randy.nextInt(Integer.MAX_VALUE) + ".png";
//			String filename = root + id ;
//			BufferedImage src = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
//			File destination = new File(filename); 
//			ImageIO.write(src, "png", destination);
//			newEvent.setImageUrl(id);
//		}
		
		return eventRepo.save(newEvent);
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

}
