package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.TimeTableDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "time_table")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "room_number")
    private int roomNumber;

    private Date day;

    @Column(name = "time_start")
    private Date timeStart;

    @Column(name = "time_end")
    private Date timeEnd;

    public TimeTable(TimeTableDTO timeTableDTO){
        this.id = timeTableDTO.getId();
        this.roomNumber = timeTableDTO.getRoomNumber();
        this.day = timeTableDTO.getDay();
        this.timeStart = timeTableDTO.getTimeStart();
        this.timeEnd = timeTableDTO.getTimeEnd();
    }
}
