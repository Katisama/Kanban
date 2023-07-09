package de.jikugmbh.kanbanboard.backend.user.entity;

import de.jikugmbh.kanbanboard.backend.project.entity.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String eMail;
    private String password;

}
