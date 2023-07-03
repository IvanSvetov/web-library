package skypro.java.course4.weblibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.java.course4.weblibrary.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);

}
