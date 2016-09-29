package nl.getthere.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by jasper.dejong on 27-9-2016.
 */
@Entity
public class Student{
	@NotEmpty(message="Voer aub een voornaam in. ")
	private String firstName;
	@NotEmpty(message="Voer aub een achternaam in. ")
    private String lastName;
	@NotEmpty(message="Voer aub een email in. ") @Email(message="Controleer het opgegeven emailadres. ")
    private String email;
    private String phone;
	private LocalDate dateJoined;
	@NotNull
    private Education education;
    private LocalDate startEducation;
    private LocalDate endEducation;
    private LinkedInConnectionStatus linkedInConnectionStatus;
    @NotNull
    private Boolean isInterestedInEvents;
    private String contactOrigin;
    @NotNull
    private LocalDate dateOfBirth;
    private Long id;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    public void setId(Long id) {
        this.id = id;
    }

    public enum LinkedInConnectionStatus {
        approved, declined, pending
    }
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
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

    @DateTimeFormat(pattern="yyyy-MM-dd") 
    public LocalDate getStartEducation() {
        return startEducation;
    }
    
    public void setStartEducation(LocalDate startEducation) {
        this.startEducation = startEducation;
    }
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
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
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
