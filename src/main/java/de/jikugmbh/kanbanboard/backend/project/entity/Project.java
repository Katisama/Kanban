package de.jikugmbh.kanbanboard.backend.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Projects")

public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

}
