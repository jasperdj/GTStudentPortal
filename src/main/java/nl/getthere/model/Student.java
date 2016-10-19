package nl.getthere.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import nl.getthere.controllers.StudentController;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
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
	@Size(min=10,max=10, message="Controleer nummer.")
    private String phone;
	private LocalDate dateJoined;
    private Education education;
    private LocalDate startEducation;
    private LocalDate endEducation;
    private LinkedInConnectionStatus linkedInConnectionStatus;
    private Boolean isInterestedInEvents;
    private String contactOrigin;
    private LocalDate dateOfBirth;
    private Long id;
    private List<StudentComment> studentComments;
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @Column(nullable = false, unique = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(unique = true) 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    @Column(nullable = true, unique = true)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

    public enum LinkedInConnectionStatus {
        approved, declined, pending
    }

    @Generated(GenerationTime.INSERT) 
    @Column(name="date_joined", insertable=false)
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
    @Column(nullable = true, unique = false)
    public LocalDate getStartEducation() {
        return startEducation;
    }
    public void setStartEducation(LocalDate startEducation) {
        this.startEducation = startEducation;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(nullable = true, unique = false)
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

    @Column(nullable = true, unique = false)
    public String getContactOrigin() {
        return contactOrigin;
    }
    public void setContactOrigin(String contactOrigin) {
        this.contactOrigin = contactOrigin;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(nullable = true, unique = false)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getInterestedInEvents() {
        return isInterestedInEvents;
    }

    public void setInterestedInEvents(Boolean interestedInEvents) {
        isInterestedInEvents = interestedInEvents;
    }

    @OneToMany
    public List<StudentComment> getStudentComments() {
        return studentComments;
    }
    public void setStudentComments(List<StudentComment> studentComments) {
        this.studentComments = studentComments;
    }
}
