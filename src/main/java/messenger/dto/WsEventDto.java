package messenger.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import messenger.domain.Views;


@Data
@AllArgsConstructor
@JsonView(Views.Id.class)
public class WsEventDto {
    private ObjectType objectType;
    private EventType eventType;
    //Встраивание строки в json, чтобы в json не попал еще один json
    @JsonRawValue
    private String body;

}
