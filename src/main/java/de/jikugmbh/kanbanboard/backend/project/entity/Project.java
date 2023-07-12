package de.jikugmbh.kanbanboard.backend.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
