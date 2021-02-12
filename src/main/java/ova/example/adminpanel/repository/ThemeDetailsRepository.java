package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ova.example.adminpanel.models.ThemeDetails;

public interface ThemeDetailsRepository extends JpaRepository<ThemeDetails, Long> {
}
