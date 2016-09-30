package nl.getthere.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jasper.dejong on 27-9-2016.
 */

@Entity
public class University {
    private String name;
    private Long id;
    private List<Education> educations;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "university")
    public List<Education> getEducations() {
        return educations;
    }
    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }
}
