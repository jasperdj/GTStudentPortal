package nl.getthere.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jasper.dejong on 4-10-2016.
 */
@Entity
public class EventType {
    private String name;
    private Long id;
    private List<Event> events;

    @ManyToMany(mappedBy = "eventTypes")
    private List<Event> getEvents() {
        return events;
    }
    private void setEvents(List<Event> events) {
        this.events = events;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
