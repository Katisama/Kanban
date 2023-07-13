package de.jikugmbh.kanbanboard.backend.user.control;

import de.jikugmbh.kanbanboard.backend.user.entity.User;
import de.jikugmbh.kanbanboard.web.register.model.UserRegisterModel;

import java.util.function.Function;

public class UserRegisterModelToUserMapper implements Function<UserRegisterModel, User> {
    @Override
    public User apply(UserRegisterModel userRegisterModel) {
        return User.builder()
                .firstName(userRegisterModel.getFirstName())
                .lastName(userRegisterModel.getLastName())
                .email(userRegisterModel.getEmail())
                .password(userRegisterModel.getPassword())
                .build();
    }
}
