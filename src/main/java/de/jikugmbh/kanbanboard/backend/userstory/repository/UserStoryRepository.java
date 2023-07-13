package de.jikugmbh.kanbanboard.backend.userstory.repository;

import de.jikugmbh.kanbanboard.backend.userstory.entity.StoryStatus;
import de.jikugmbh.kanbanboard.backend.userstory.entity.UserStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository extends CrudRepository<UserStory, Long> {
    List<UserStory> findUserStoryByStatus(StoryStatus storyStatus);
}
