package de.jikugmbh.kanbanboard.backend.user.boundary;

import de.jikugmbh.kanbanboard.backend.user.entity.User;
import de.jikugmbh.kanbanboard.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserBoundary {
    private final UserRepository userRepository;

    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
