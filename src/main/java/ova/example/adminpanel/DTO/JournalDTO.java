package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Journal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Сущность журнал посещаемости")
public class JournalDTO {
    private Long id;

    @Schema(description = "Студент")
    private Long userId;

    @Schema(description = "Урок")
    private Long lessonId;

    @Schema(description = "Отметка об отсутствии")
    private boolean absent;

    @Schema(description = "Причина отсутствия")
    private String absentReason;

    public static JournalDTO fromModel(Journal journal){
        JournalDTO journalDTO = new JournalDTO();
        journalDTO.setId(journalDTO.getId());
        journalDTO.setUserId(journal.getUser().getId());
        journalDTO.setLessonId(journal.getLessonId());
        journalDTO.setAbsent(journal.isAbsent());
        journalDTO.setAbsentReason(journal.getAbsentReason());

        return journalDTO;
    }
}
