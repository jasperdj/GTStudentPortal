package nl.getthere.model;

import javax.persistence.*;

/**
 * Created by jasper.dejong on 27-9-2016.
 */

//Todo setting column values. I.E @Column(name = "email", nullable = false, unique = true)
@Entity
public class Education {
    private String name;
    private Degree degree;
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    private University university;

    @ManyToOne
    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum Degree {
        hbo, wo
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
