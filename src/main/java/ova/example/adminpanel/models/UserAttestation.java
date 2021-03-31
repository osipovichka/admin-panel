package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_attestation")
public class UserAttestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "users_id")
    private int userId;

    @Column(name = "attestation_theme_id")
    private int attestationThemeId;

    @Column(name = "theory_passed")
    private boolean theoryPassed;

    @Column(name = "practice_passed")
    private boolean practicePassed;
}
