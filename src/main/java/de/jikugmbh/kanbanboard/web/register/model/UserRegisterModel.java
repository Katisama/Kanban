package de.jikugmbh.kanbanboard.web.register.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
