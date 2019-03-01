package messenger.controller;

import com.fasterxml.jackson.annotation.JsonView;
import messenger.domain.Message;
import messenger.domain.Views;
import messenger.domain.WcSender;
import messenger.dto.EventType;
import messenger.dto.ObjectType;
import messenger.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("message")
public class MessageController {
    private int counter = 4;
    private final BiConsumer<EventType, Message> wcSender;
    private MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo, WcSender wcSender) {
        this.wcSender = wcSender.getSender(ObjectType.MESSAGE, Views.IdName.class);
        this.messageRepo = messageRepo;
    }


    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }


    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        Message updatedMessage = messageRepo.save(message);
        wcSender.accept(EventType.CREATE, updatedMessage);
        return updatedMessage;
    }

    @PutMapping("{id}")
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message
    ) {
        //Скопирует все данные из message в messageFromDb, кроме id
        BeanUtils.copyProperties(message, messageFromDb, "id");
        Message updatedMessage = messageRepo.save(messageFromDb);
        wcSender.accept(EventType.UPDATE, updatedMessage);
        return updatedMessage;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
        wcSender.accept(EventType.REMOVE, message);
    }

}
