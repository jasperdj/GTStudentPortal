package nl.getthere.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import nl.getthere.model.Event;
import nl.getthere.model.EventTheme;
import nl.getthere.model.EventType;
import nl.getthere.model.User;
import nl.getthere.model.respositories.EventRepository;
import nl.getthere.model.respositories.EventThemeRepository;
import nl.getthere.model.respositories.EventTypeRespository;
import nl.getthere.model.respositories.UserRepository;
import nl.getthere.security.CurrentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jasper.dejong on 4-10-2016.
 */

@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private EventTypeRespository eventTypeRepo;
    @Autowired
    private EventThemeRepository eventThemeRepo;
    @Autowired
    private UserRepository userRepo;

    @ModelAttribute("event")
    public Event getEvent(){
        return new Event();
    }

    @ModelAttribute("eventType")
    public EventType getEventType(){
        return new EventType();
    }

    @ModelAttribute("eventTheme")
    public EventTheme getEventTheme(){
        return new EventTheme();
    }

    @RequestMapping("/events/{eventid}")
    public String showEventDetail(@PathVariable Long eventid, Model model){
    	Event e = eventRepo.findOne(eventid);
    	if(e == null){
    		return "404";
    	}

    	model.addAttribute("user", userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail()));
    	model.addAttribute("event", e);
    	return "eventdetail";
    }

    @RequestMapping("/events/{eventid}/signin")
    public String signinEvent(@PathVariable Long eventid, Model model){
    	if(CurrentUser.getCurrentUser() == null){
    		return "redirect:/registration";
    	}
    	User user = userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail());
		Event event = eventRepo.findOne(eventid);
		if(event.getAttendees() == null){
			event.setAttendees(new ArrayList<User>());
		}
		event.getAttendees().add(user);

		if(user.getEventsAttending() == null){
			user.setEventsAttending(new ArrayList<Event>());
		}
		user.getEventsAttending().add(event);
		userRepo.save(user);
		eventRepo.save(event);
    	model.addAttribute("status", "Je bent nu ingeschreven voor het event!");
    	return "redirect:/events/" + eventid + "/";
    }

    @RequestMapping(value = "/api/newEvent", method = RequestMethod.POST)
    public String newEventPost(Model model, @Valid Event event, BindingResult result, @RequestParam("image") MultipartFile image) throws IOException {
        model.addAttribute("error", result);
        System.out.println("RESULT:\n\n\n\n\n\n"+result);
        
        Resource resource = new ClassPathResource("/application.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		String root = props.getProperty("event.image.location");

		Random randy = new Random();

		if (!image.isEmpty()) {
			String id = randy.nextInt() + ".png";
			String filename = root + id ;
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
			File destination = new File(filename); 
			ImageIO.write(src, "png", destination);
			event.setImageUrl(id);
		}

        eventRepo.save(event);
        return "newEvent";
    }

    //todo: Map this for Recruiters only.
    @RequestMapping(value = "/api/newEvent", method = RequestMethod.GET)
    public String newEvent(Model model) {
        return "newEvent";
    }

    @RequestMapping(value = "/api/getEvents")
    public @ResponseBody List<Event> getEvents(Model model, int from, int to) {
        return getEventsBetweenDays(from, to);
    }

    @RequestMapping("/api/events/{id}")
    public @ResponseBody Event getEvent(@PathVariable Long id){
    	Event e = eventRepo.findOne(id);
    	if(e == null){
    		return null;
    	}
    	return e;
    }
    
    @RequestMapping(value = "/api/events/{eventid}", method = RequestMethod.PUT)
    public @ResponseBody String signInToEvent(@PathVariable Long eventid){
    	
    	User user = userRepo.findOneByEmail(CurrentUser.getCurrentUser().getEmail());
    	if(user == null){
    		return "403";
    	}
		Event event = eventRepo.findOne(eventid);
		
		if(event.getAttendees() == null){
			event.setAttendees(new ArrayList<User>());
		}

		if(user.getEventsAttending() == null){
			user.setEventsAttending(new ArrayList<Event>());
		}
		
		if(user.getEventsAttending().contains(event)){
			user.getEventsAttending().remove(event);
			event.getAttendees().remove(user);
		}else{
			user.getEventsAttending().add(event);
			event.getAttendees().add(user);
		}
		
		userRepo.save(user);
		eventRepo.save(event);
    	
    	return "200";
    }
    

    public List<Event> getEventsBetweenDays(int fromDaysOffset, int toDaysOffset) {
        LocalDateTime now = LocalDateTime.now().withHour(1).plusDays(fromDaysOffset);
        LocalDateTime end = LocalDateTime.now().withHour(23).plusDays(toDaysOffset);

        Iterable<Event> all = eventRepo.findAll();
        List<Event> list = StreamSupport.stream(all.spliterator(), false)
                .filter(x -> x.getStart().isAfter(now) && x.getStart().isBefore(end))
                .collect(Collectors.toList());

        return list;
    }

    @RequestMapping(value = "/api/addEventType", method = RequestMethod.GET)
    public @ResponseBody EventType addEventType(Model model, EventType eventType) {
        return eventTypeRepo.save(eventType);
    }

    @RequestMapping(value = "/api/addEventTheme", method = RequestMethod.GET)
    public @ResponseBody EventTheme addEventTheme(Model model, EventTheme eventTheme) {
        return eventThemeRepo.save(eventTheme);
    }

    @RequestMapping(value= "/api/getEventTypes", method = RequestMethod.GET)
    public @ResponseBody Iterable<EventType> getEventTypes(Model model) {
        return eventTypeRepo.findAll();
    }

    @RequestMapping(value = "/api/getEventThemes", method = RequestMethod.GET)
    public @ResponseBody Iterable<EventTheme> getEventThemes(Model model) {
        return eventThemeRepo.findAll();
    }

    @RequestMapping("/api/events/")
    public @ResponseBody Iterable<Event>getEvents(Model model){
    	return eventRepo.findAll();
    }
}
