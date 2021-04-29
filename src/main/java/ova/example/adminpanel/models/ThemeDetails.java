package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.ThemeDetailsDTO;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_details_id")
    private ProgramDetails programDetails;

    private String topic;

    @ManyToMany(mappedBy = "themeDetails")
    private List<Lesson> lessons;

    public ThemeDetails(ThemeDetailsDTO themeDetailsDTO){
        this.id = themeDetailsDTO.getId();
        this.topic = themeDetailsDTO.getTopic();
    }
}
