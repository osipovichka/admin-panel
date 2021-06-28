package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.GroupDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_program_id")
    private CourseProgram courseProgram;

    @ManyToMany(mappedBy = "groups")
    private List<User> teachers;

    @ManyToMany(mappedBy = "group")
    private List<User> students;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Lesson> lesson = new HashSet<>();

    public Group(GroupDTO groupDTO) {
        this.id = groupDTO.getId();
        this.startDate = groupDTO.getStartDate();
        this.endDate = groupDTO.getEndDate();
    }
}
