package messenger.controller;

import com.fasterxml.jackson.annotation.JsonView;
import messenger.domain.Comment;
import messenger.domain.User;
import messenger.domain.Views;
import messenger.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    @JsonView(Views.FullComment.class)

    public Comment create(
            @RequestBody Comment comment,
            @AuthenticationPrincipal User user

    ){
        return commentService.create(comment, user);
    }
}
