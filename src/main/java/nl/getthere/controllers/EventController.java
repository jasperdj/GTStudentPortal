package nl.getthere.controllers;

import javax.validation.Valid;

import nl.getthere.model.Event;
import nl.getthere.model.EventTheme;
import nl.getthere.model.EventType;
import nl.getthere.model.respositories.EventRespository;
import nl.getthere.model.respositories.EventThemeRepository;
import nl.getthere.model.respositories.EventTypeRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jasper.dejong on 4-10-2016.
 */

@Controller
public class EventController {
    @Autowired
    private EventRespository eventRepo;
    @Autowired
    private EventTypeRespository eventTypeRepo;
    @Autowired
    private EventThemeRepository eventThemeRepo;

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

    @RequestMapping(value = "/api/newEvent", method = RequestMethod.POST)
    public String newEventPost(Model model, @Valid Event event, BindingResult result) {
        model.addAttribute("error", result);
        System.out.println("RESULT:\n\n\n\n\n\n"+result);
        eventRepo.save(event);
        return "newEvent";
    }

    //todo: Map this for Recruiters only.
    @RequestMapping(value = "/api/newEvent", method = RequestMethod.GET)
    public String newEvent(Model model) {
        return "newEvent";
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
