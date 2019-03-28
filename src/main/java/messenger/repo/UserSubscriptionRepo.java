package messenger.repo;

import messenger.domain.User;
import messenger.domain.UserSubscription;
import messenger.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
List<UserSubscription> findBySubscriber(User user);
}
