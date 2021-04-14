package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "group_id")
    private Long groupId;

    private Date day;

    @Column(name = "home_task")
    private String homeTask;

    private String read;
    private String videos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lesson_topic",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_details_id")
    )
    private List<ThemeDetails> themeDetails;
}
