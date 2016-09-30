package nl.getthere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by jasper.dejong on 27-9-2016.
 */

//Todo setting column values. I.E @Column(name = "email", nullable = false, unique = true)

@Entity
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Boolean recruiter;
    private String userRole;
    private Student student;

	public User() {

    }

    public User(String firstName, String lastName, String email, String phone, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
        this.userRole = "student";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Boolean recruiter) {
        this.recruiter = recruiter;
    }
    
    @OneToOne
   	public Student getStudent() {
   		return student;
   	}

   	public void setStudent(Student student) {
   		this.student = student;
   	}
}