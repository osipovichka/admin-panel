package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
