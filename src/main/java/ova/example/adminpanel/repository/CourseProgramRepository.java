package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.CourseProgram;

@Repository
public interface CourseProgramRepository extends JpaRepository<CourseProgram, Long> {
}
