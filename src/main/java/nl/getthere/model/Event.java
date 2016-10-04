package nl.getthere.model;

import org.apache.xpath.operations.Bool;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jasper.dejong on 4-10-2016.
 */
@Entity
public class Event {
    private List<EventType> eventTypes;
    private List<EventTheme> eventThemes;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean published;
    private String description;
    private List<User> attendiesAccepted;
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany
    public List<EventType> getEventTypes() {
        return eventTypes;
    }
    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    @OneToMany
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

    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Boolean getPublished() {
        return published;
    }
    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    public List<User> getAttendiesAccepted() {
        return attendiesAccepted;
    }
    public void setAttendiesAccepted(List<User> attendiesAccepted) {
        this.attendiesAccepted = attendiesAccepted;
    }


}
