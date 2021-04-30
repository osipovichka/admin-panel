package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
