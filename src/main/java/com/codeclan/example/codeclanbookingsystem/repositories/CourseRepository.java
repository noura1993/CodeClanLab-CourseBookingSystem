package com.codeclan.example.codeclanbookingsystem.repositories;

import com.codeclan.example.codeclanbookingsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(Integer rating);
}
