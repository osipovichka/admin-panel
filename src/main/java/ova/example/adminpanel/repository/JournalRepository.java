package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.Jurnal;

@Repository
public interface JournalRepository extends JpaRepository<Jurnal, Long> {
}
