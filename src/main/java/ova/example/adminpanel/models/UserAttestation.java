package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.UserAttestationDTO;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_attestation")
public class UserAttestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attestation_theme_id")
    private AttestationTheme attestationTheme;

    @Column(name = "theory_passed")
    private boolean theoryPassed;

    @Column(name = "practice_passed")
    private boolean practicePassed;

    public UserAttestation(UserAttestationDTO userAttestationDTO){
        this.id = userAttestationDTO.getId();
        this.theoryPassed = userAttestationDTO.isTheoryPassed();
        this.practicePassed = userAttestationDTO.isPracticePassed();
    }

}
