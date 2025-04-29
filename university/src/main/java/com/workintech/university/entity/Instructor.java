package com.workintech.university.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "instructor", schema = "university")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @NotNull
    @Size(max = 70)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "course_instructor",
            schema = "university",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public void addCourse(Course course){
        if(course == null) courses = new HashSet<>();
        courses.add(course);
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Instructor instructor = (Instructor) obj;
        return instructor.getId().equals(this.id);
    }

}
