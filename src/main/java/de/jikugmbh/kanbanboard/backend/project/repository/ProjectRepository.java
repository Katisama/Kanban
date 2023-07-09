package de.jikugmbh.kanbanboard.backend.project.repository;


import de.jikugmbh.kanbanboard.backend.project.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
