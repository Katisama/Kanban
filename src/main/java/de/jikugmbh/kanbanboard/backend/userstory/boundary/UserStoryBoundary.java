package de.jikugmbh.kanbanboard.backend.userstory.boundary;

import de.jikugmbh.kanbanboard.backend.userstory.entity.UserStory;
import de.jikugmbh.kanbanboard.backend.userstory.repository.UserStoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStoryBoundary {
    private final UserStoryRepository userStoryRepository;

    public Optional<UserStory> getUserStoryById(Long id) {
        return userStoryRepository.findById(id);
    }

    public UserStory save(UserStory newUserStory) {
        return userStoryRepository.save(newUserStory);
    }


    public UserStory update(UserStory updatedUserStory) {
        return userStoryRepository.save(updatedUserStory);
    }

    public void delete(Long id) {
        userStoryRepository.deleteById(id);
    }


}
