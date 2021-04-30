package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.JournalDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "lesson_id")
    private Long lessonId;

    private boolean absent;

    @Column(name = "absent_reason")
    private String absentReason;

    private String feadback;

    public Journal(JournalDTO journalDTO){
        this.id = journalDTO.getId();
        this.lessonId = journalDTO.getLessonId();
        this.absent = journalDTO.isAbsent();
        this.absentReason = journalDTO.getAbsentReason();
        this.feadback = journalDTO.getFeadback();
    }

    // TODO: 30.04.2021 разобраться со связью lessonId
}
