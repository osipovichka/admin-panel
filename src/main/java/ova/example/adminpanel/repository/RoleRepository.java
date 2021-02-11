package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
