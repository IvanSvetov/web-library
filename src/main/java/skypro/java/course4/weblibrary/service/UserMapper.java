package skypro.java.course4.weblibrary.service;

import org.springframework.stereotype.Component;
import skypro.java.course4.weblibrary.controller.dto.UserDTO;
import skypro.java.course4.weblibrary.model.User;

@Component
public class UserMapper {

    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
