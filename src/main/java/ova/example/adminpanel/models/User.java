package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String patronymic;

    @Column(name = "birth_date")
    private Date birthDate;

    private String email;

    private String phone;

    private String password;
    @Transient
    private String confirmPassword;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "registration_date")
    private Date registrationDate;
}
