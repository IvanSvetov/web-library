package skypro.java.course4.weblibrary.controller.dto;

import lombok.Data;
import skypro.java.course4.weblibrary.model.Role;
@Data
public class UserDTO {

    private int id;
    private String login;
    private String password;
    private Role role;
}
