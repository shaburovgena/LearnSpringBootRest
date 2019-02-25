package messenger.repo;

import messenger.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository <User, String> {
}
