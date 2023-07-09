package de.jikugmbh.kanbanboard.backend.user.repository;

import de.jikugmbh.kanbanboard.backend.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}