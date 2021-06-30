package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Lesson;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Сущность урока")
public class LessonDTO {
    private Long id;

    @Schema(description = "Группа в которой проходит данный урок")
    private Long groupId;

    @Schema(description = "День в который проходит данный урок")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date day;

    @Schema(description = "Домашнее задание к уроку")
    private String homeTask;

    @Schema(description = "Литератула для изучения по теме урока")
    private String read;

    @Schema(description = "Ссылка на видео материалы к теме урока")
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
