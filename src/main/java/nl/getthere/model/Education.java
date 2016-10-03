package nl.getthere.model;

import javax.persistence.*;

/**
 * Created by jasper.dejong on 27-9-2016.
 */

@Entity
public class Education {
    private String name;
    private Degree degree;
    private Long id;

    public enum Degree {
        hbo, wo
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private University university;

    @ManyToOne
    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }


    @Column(nullable = false, unique = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //todo figure out enum type and make nullable=false
    @Column(nullable = true, unique = false)
    public Degree getDegree() {
        return degree;
    }
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
