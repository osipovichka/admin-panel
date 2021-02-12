package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="news")
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String content;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "author_id")
    private int author;

    @Column(name = "recipient_id")
    private int recipient;

    @Column(name = "group_id")
    private int groupId;
}
