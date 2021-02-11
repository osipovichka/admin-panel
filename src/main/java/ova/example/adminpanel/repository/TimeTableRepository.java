package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.TimeTable;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
}
