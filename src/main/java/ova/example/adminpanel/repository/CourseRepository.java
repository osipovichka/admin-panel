package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
