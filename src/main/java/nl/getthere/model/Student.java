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


//Sprint security, sprint boot and sprint security

@Entity
public class Student extends User {
    private LocalDate dateJoined;
    private Education education;
    private LocalDate startEducation;
    private LocalDate endEducation;
    private LinkedInConnectionStatus linkedInConnectionStatus;
    private Boolean isInterestedInEvents;
    private String contactOrigin;
    private LocalDate dateOfBirth;
    private Long id;

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

    public Boolean getIsInterestedInEvents() {
        return isInterestedInEvents;
    }

    public void setIsInterestedInEvents(Boolean interestedInEvents) {
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
