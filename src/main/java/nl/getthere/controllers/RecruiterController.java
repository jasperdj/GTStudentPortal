package nl.getthere.controllers;

import java.util.List;

import nl.getthere.model.Event;
import nl.getthere.model.Student;
import nl.getthere.model.respositories.EventRepository;
import nl.getthere.model.respositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "recruiterapi/events/", method = RequestMethod.POST)
	public @ResponseBody Event createEvent(@RequestBody Event newEvent) {
		System.out.println(newEvent);
		System.out.println("Bleep!");
		return null;
	}
	
	@RequestMapping(value = "recruiterapi/events/{eventid}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteEvent(){
		
		return "";
	}

}
