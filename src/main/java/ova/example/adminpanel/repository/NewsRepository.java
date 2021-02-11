package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.New;

@Repository
public interface NewsRepository extends JpaRepository<New, Long> {
}
