package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.New;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NewDTO {
    private Long id;
    private String title;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date publicationDate;

    private Long authorId;
    private Long recipientId;
    private Long groupId;

    public static NewDTO fromModel(New newsItem){
        NewDTO newDTO = new NewDTO();
        newDTO.setId(newsItem.getId());
        newDTO.setTitle(newsItem.getTitle());
        newDTO.setContent(newsItem.getContent());
        newDTO.setPublicationDate(newsItem.getPublicationDate());
        newDTO.setAuthorId(newsItem.getAuthor().getId());
        newDTO.setRecipientId(newsItem.getRecipient().getId());
        newDTO.setGroupId(newsItem.getGroup().getId());

        return newDTO;
    }
}
