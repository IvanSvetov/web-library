package skypro.java.course4.weblibrary.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "'user'")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
