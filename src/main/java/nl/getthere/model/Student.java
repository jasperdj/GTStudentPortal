package nl.getthere.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by jasper.dejong on 27-9-2016.
 */


//Todo setting column values. I.E @Column(name = "email", nullable = false, unique = true)

@Entity
public class Student {
    private LocalDate dateJoined;
    private Education education;
    private LocalDate startEducation;
    private LocalDate endEducation;
    private LinkedInConnectionStatus linkedInConnectionStatus;
    private Boolean isInterestedInEvents;
    private String contactOrigin;
    private LocalDate dateOfBirth;
    private Long id;

	public Student(String firstName, String lastName, String email, String phone, String password, LocalDate dateJoined, Education education, LocalDate startEducation, LocalDate endEducation, LocalDate dateOfBirth) {
		this.dateJoined = dateJoined;
		this.education = education;
		this.startEducation = startEducation;
		this.endEducation = endEducation;
		this.dateOfBirth = dateOfBirth;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum LinkedInConnectionStatus {
        approved, declined, pending
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }
    
    @ManyToOne
    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public LocalDate getStartEducation() {
        return startEducation;
    }

    public void setStartEducation(LocalDate startEducation) {
        this.startEducation = startEducation;
    }

    public LocalDate getEndEducation() {
        return endEducation;
    }

    public void setEndEducation(LocalDate endEducation) {
        this.endEducation = endEducation;
    }

    public LinkedInConnectionStatus getLinkedInConnectionStatus() {
        return linkedInConnectionStatus;
    }

    public void setLinkedInConnectionStatus(LinkedInConnectionStatus linkedInConnectionStatus) {
        this.linkedInConnectionStatus = linkedInConnectionStatus;
    }

    public Boolean getInterestedInEvents() {
        return isInterestedInEvents;
    }

    public void setInterestedInEvents(Boolean interestedInEvents) {
        isInterestedInEvents = interestedInEvents;
    }

    public String getContactOrigin() {
        return contactOrigin;
    }

    public void setContactOrigin(String contactOrigin) {
        this.contactOrigin = contactOrigin;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
