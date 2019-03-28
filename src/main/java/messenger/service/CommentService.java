package messenger.service;

import messenger.domain.Comment;
import messenger.domain.User;
import messenger.domain.Views;
import messenger.domain.WsSender;
import messenger.dto.EventType;
import messenger.dto.ObjectType;
import messenger.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {

    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wcSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wcSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);
        wcSender.accept(EventType.CREATE, commentFromDb);
        return comment;
    }
}
