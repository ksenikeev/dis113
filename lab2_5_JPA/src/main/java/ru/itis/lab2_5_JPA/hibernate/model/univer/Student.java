package ru.itis.lab2_5_JPA.hibernate.model.univer;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @SequenceGenerator(name="studentGenId", sequenceName="student_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="studentGenId")
    private Long id;

    private String name;

    @ManyToOne
    private Groupp groupp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Groupp getGroupp() {
        return groupp;
    }

    public void setGroupp(Groupp groupp) {
        this.groupp = groupp;
    }
}
