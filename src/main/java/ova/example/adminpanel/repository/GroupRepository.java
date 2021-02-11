package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
