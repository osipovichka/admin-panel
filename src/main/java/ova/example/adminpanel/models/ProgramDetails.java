package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.ProgramDetailsDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="program_details")
public class ProgramDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "lesson_number")
    private int lessonNumber;

    @Column(name = "lesson_theme")
    private String lessonTheme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_program_id")
    private CourseProgram courseProgram;

    @OneToMany(mappedBy = "programDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ThemeDetails> themeDetails = new HashSet<>();

    public ProgramDetails(ProgramDetailsDTO programDetailsDTO) {
        this.id = programDetailsDTO.getId();
        this.lessonNumber = programDetailsDTO.getLessonNumber();
        this.lessonTheme = programDetailsDTO.getLessonTheme();
    }
}
