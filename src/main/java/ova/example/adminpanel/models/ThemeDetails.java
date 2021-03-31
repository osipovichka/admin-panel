package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="theme_details")
public class ThemeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "program_details_id")
    private int programDetailsId;

    private String topic;

    @ManyToMany(mappedBy = "themeDetails")
    private List<Lesson> lessons;
}
