package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.TimeTable;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TimeTableDTO {
    private Long id;
    private Long groupId;
    private int roomNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date day;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date timeStart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date timeEnd;

    public static TimeTableDTO fromModel(TimeTable timeTable){
        TimeTableDTO timeTableDTO = new TimeTableDTO();
        timeTableDTO.setId(timeTable.getId());
        timeTableDTO.setGroupId(timeTable.getGroup().getId());
        timeTableDTO.setRoomNumber(timeTable.getRoomNumber());
        timeTableDTO.setDay(timeTable.getDay());
        timeTableDTO.setTimeStart(timeTable.getTimeStart());
        timeTableDTO.setTimeEnd(timeTable.getTimeEnd());

        return timeTableDTO;
    }
}
