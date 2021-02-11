package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.UserAttestation;

@Repository
public interface UserAttestationRepository extends JpaRepository<UserAttestation, Long> {
}
