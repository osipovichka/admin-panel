package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.AttestationThemeDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attestation_theme")
public class AttestationTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    private String theme;

    @OneToMany(mappedBy = "attestationTheme", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserAttestation> userAttestations = new HashSet<>();

    public AttestationTheme(AttestationThemeDTO attestationThemeDTO){
        this.id = attestationThemeDTO.getId();
        this.theme = attestationThemeDTO.getTheme();
    }
}
