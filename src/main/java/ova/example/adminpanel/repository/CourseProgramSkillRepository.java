package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.CourseProgramSkill;

@Repository
public interface CourseProgramSkillRepository extends JpaRepository<CourseProgramSkill,Long> {
}
