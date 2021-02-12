package ova.example.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ova.example.adminpanel.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    List<User> findAllUsers();

}
