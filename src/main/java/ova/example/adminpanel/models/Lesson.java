package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.LessonDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    private Date day;

    @Column(name = "home_task")
    private String homeTask;

    private String read;
    private String videos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_details_id")
    private ProgramDetails programDetails;

    public Lesson(LessonDTO lessonDTO){
        this.id = lessonDTO.getId();
        this.day = lessonDTO.getDay();
        this.homeTask = lessonDTO.getHomeTask();
        this.read = lessonDTO.getRead();
        this.videos = lessonDTO.getVideos();
    }
}
