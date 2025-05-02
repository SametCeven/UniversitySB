package com.workintech.university.repository;

import com.workintech.university.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    @Query("SELECT f FROM Faculty f WHERE f.name LIKE %:name%")
    List<Faculty> searchFacultyByName(@Param("name") String facultyName);

    @Query("SELECT f FROM Faculty f WHERE f.name LIKE %.search% OR f.email LIKE '%:search%'")
    List<Faculty> searchByFacultyNameOrEmail(@Param("search") String name);

}
