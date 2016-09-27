package nl.getthere.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by jasper.dejong on 27-9-2016.
 */
public class Student {
    private LocalDate dateJoined;
    private Education education;
    private LocalDate startEducation;
    private LocalDate endEducation;
    private List<Role> roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
