package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.CourseDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseProgram> coursePrograms = new HashSet<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AttestationTheme> attestationThemes = new HashSet<>();

    public Course(CourseDTO courseDTO) {
        this.id = courseDTO.getId();
        this.name = courseDTO.getName();
        this.description = courseDTO.getDescription();
        this.price = courseDTO.getPrice();
    }
}
