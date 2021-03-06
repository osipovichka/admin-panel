package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.ProgramDetails;

@Repository
public interface ProgramDetailsRepository extends JpaRepository<ProgramDetails, Long> {
}
