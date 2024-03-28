package pk.edu.nust.seecs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.edu.nust.seecs.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> getUsersByUsernameAndPassword(String username, String password);
}
