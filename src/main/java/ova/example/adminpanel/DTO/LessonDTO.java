package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Lesson;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LessonDTO {
    private Long id;
    private Long groupId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date day;
    private String homeTask;
    private String read;
    private String videos;

    public static LessonDTO fromModel(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setId(lesson.getId());
        lessonDTO.setGroupId(lesson.getGroup().getId());
        lessonDTO.setDay(lesson.getDay());
        lessonDTO.setHomeTask(lesson.getHomeTask());
        lessonDTO.setRead(lesson.getRead());
        lessonDTO.setVideos(lesson.getVideos());

        return lessonDTO;
    }
}
