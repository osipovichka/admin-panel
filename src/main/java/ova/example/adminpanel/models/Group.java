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
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "time_start")
    private Date timeStart;

    private int duration;

    @Column(name = "course_program_id")
    private Long courseProgramId;

    @ManyToMany(mappedBy = "groups")
    private List<User> teachers;

    @ManyToMany(mappedBy = "group")
    private List<User> students;
}
