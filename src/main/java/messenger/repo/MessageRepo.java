package messenger.repo;

import messenger.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository <Message, Long> {

}
