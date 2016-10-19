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
    private LocalDateTime timestamp;
    private LocalDate reminder;

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

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    public LocalDate getReminder() {
        return reminder;
    }
    public void setReminder(LocalDate reminder) {
        this.reminder = reminder;
    }
}
