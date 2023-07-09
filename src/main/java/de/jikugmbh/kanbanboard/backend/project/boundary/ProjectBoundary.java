package de.jikugmbh.kanbanboard.backend.project.boundary;


import de.jikugmbh.kanbanboard.backend.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectBoundary {
    private final ProjectRepository projectRepository;


}
