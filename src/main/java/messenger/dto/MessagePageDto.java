package messenger.dto;

import com.fasterxml.jackson.annotation.JsonView;
import messenger.domain.Message;
import messenger.domain.Views;

import java.util.List;

//Разобраться
@JsonView(Views.FullMessage.class)
public class MessagePageDto {
private List<Message>messages;
private int currentPage;
private long totalPages;


    public MessagePageDto() {
    }

    public MessagePageDto(List<Message> messages, int currentPage, int totalPages) {
        this.messages = messages;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
