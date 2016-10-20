package nl.getthere.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by jasper.dejong on 19-10-2016.
 */
@Entity
public class StudentComment {
    private Long id;
    private String comment;
    private LocalDate reminder;
    private LocalDateTime created;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Lob
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    public LocalDate getReminder() {
        return reminder;
    }
    public void setReminder(LocalDate reminder) {
        this.reminder = reminder;
    }
    public void setReminder(String reminder) { this.reminder = LocalDate.parse(reminder); }

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public void setCreated(String created) { this.created = LocalDateTime.parse(created); }
}
