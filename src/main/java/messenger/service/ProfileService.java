package messenger.service;

import messenger.domain.User;
import messenger.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {
    private final UserDetailsRepo userDetailsRepo;

    @Autowired
    public ProfileService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    public User changeSubscription(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscribers();

        if (subscribers.contains(subscriber)) {
            System.out.println("Remove");
            subscribers.remove(subscriber);
        } else {
            System.out.println("Adding");
            subscribers.add(subscriber);
        }

        return userDetailsRepo.save(channel);
    }
}
