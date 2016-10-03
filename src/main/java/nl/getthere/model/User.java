package nl.getthere.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by jasper.dejong on 27-9-2016.
 */

@Entity
public class User {
    private Long id;
    @NotEmpty(message="Voer aub een voornaam in. ")
    private String firstName;
    @NotEmpty(message="Voer aub een achternaam in. ")
    private String lastName;
    @NotEmpty(message="Voer aub een email in. ") @Email(message="Controleer het opgegeven emailadres.")
    private String email;
    private String phone;
    @NotEmpty(message="Voer aub een wachtwoord in. (min. 8 tekens)")@Size(min=8, message="Minimaal 8 tekens.")
    private String password;
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
    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = false)
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Column(nullable = false, unique = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = true, unique = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column( nullable = false, unique = true)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false, unique = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    @OneToOne
   	public Student getStudent() {
   		return student;
   	}
   	public void setStudent(Student student) {
   		this.student = student;
   	}
}