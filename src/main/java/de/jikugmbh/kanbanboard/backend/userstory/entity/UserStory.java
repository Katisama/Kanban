package de.jikugmbh.kanbanboard.backend.userstory.entity;

import de.jikugmbh.kanbanboard.backend.project.entity.Project;
import de.jikugmbh.kanbanboard.backend.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UserStories")
public class UserStory {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private StoryType type;
    private StoryPrio priority;
    private StoryStatus status;
    @OneToOne
    private User assignee;
    private Date createdAt;
    private Date updatedAt;
    private StoryPoints estimation;
    private String text;
    @ManyToOne
    private Project project;
}
