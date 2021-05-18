package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.AttestationThemeDTO;

import javax.persistence.*;

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

    public AttestationTheme(AttestationThemeDTO attestationThemeDTO){
        this.id = attestationThemeDTO.getId();
        this.theme = attestationThemeDTO.getTheme();
    }
}
