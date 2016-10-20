package nl.getthere.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by jasper.dejong on 4-10-2016.
 */

//Todo: Add form checks notNull etc.
@Entity
public class Event {
    private List<EventType> eventTypes;
    private List<EventTheme> eventThemes;
    private String title;
    private String location;
    private int vacancy;
    private String imageUrl;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean published;
    private String description;
    private List<User> attendees;
    private Long eventId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="event_id")
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long id) {
        this.eventId = id;
    }

    @ManyToMany
    public List<EventType> getEventTypes() {
        return eventTypes;
    }
    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    @ManyToMany
    public List<EventTheme> getEventThemes() {
        return eventThemes;
    }
    public void setEventThemes(List<EventTheme> eventThemes) {
        this.eventThemes = eventThemes;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = true, unique = false)
    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    public void setStart(String start){
    	this.start = LocalDateTime.parse(start);
    }

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = true, unique = false)
    public LocalDateTime getEnd() {
        return end;
    }
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    public void setEnd(String end){
    	this.end = LocalDateTime.parse(end);
    }

    public Boolean getPublished() {
        return published;
    }
    public void setPublished(Boolean published) {
        this.published = published;
    }
    
    @Lob
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    public List<User> getAttendees() {
        return attendees;
    }
    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
    
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(nullable = true, unique = false, columnDefinition = "int(11) default '0'")
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	
}
