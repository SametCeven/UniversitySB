package com.workintech.university.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course", schema = "university")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 150)
    @NotEmpty
    @NotNull
    @Column(name = "name")
    private String name;

    @Size(max = 25)
    @Column(name = "code")
    private String code;

    @Column(name = "credit")
    private Double credit;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "course_instructor",
            schema = "university",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private Set<Instructor> instructors;


    public void addInstructor(Instructor instructor){
        if(instructor == null) instructors = new HashSet<>();
        instructors.add(instructor);
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Course course = (Course) obj;
        return course.getId().equals(this.id);
    }


}
