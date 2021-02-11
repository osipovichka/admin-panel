package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
