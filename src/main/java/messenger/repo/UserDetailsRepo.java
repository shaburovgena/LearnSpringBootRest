package messenger.repo;

import messenger.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository <User, String> {
//    При поиске пользователя по базе будут жадно подгружаться подписки и подписчики
    @EntityGraph (attributePaths = {"subscriptions", "subscribers"})
    Optional<User> findById(String s);
}
