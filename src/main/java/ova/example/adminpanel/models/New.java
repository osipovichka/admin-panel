package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.NewDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="news")
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @Column(name = "publication_date")
    private Date publicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id")
    private User recipient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public New(NewDTO newDTO){
        this.id = newDTO.getId();
        this.title = newDTO.getTitle();
        this.content = newDTO.getContent();
        this.publicationDate = newDTO.getPublicationDate();
    }
}
