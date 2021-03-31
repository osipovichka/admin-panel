package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jurnal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "users_id")
    private int userId;

    @Column(name = "lesson_id")
    private int lessonId;

    private boolean absent;

    @Column(name = "absent_reason")
    private String absentReason;

    private String feadback;
}
