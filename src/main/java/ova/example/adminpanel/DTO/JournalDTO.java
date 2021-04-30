package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Journal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JournalDTO {
    private Long id;
    private Long userId;
    private Long lessonId;
    private boolean absent;
    private String absentReason;
    private String feadback;

    public static JournalDTO fromModel(Journal journal){
        JournalDTO journalDTO = new JournalDTO();
        journalDTO.setId(journalDTO.getId());
        journalDTO.setUserId(journal.getUser().getId());
        journalDTO.setLessonId(journal.getLessonId());
        journalDTO.setAbsent(journal.isAbsent());
        journalDTO.setAbsentReason(journal.getAbsentReason());
        journalDTO.setFeadback(journal.getFeadback());

        return journalDTO;
    }
}
