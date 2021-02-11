package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.AttestationTheme;

@Repository
public interface AttestationThemeRepository extends JpaRepository<AttestationTheme, Long> {
}
