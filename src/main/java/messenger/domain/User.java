package messenger.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id", "name" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @JsonView(Views.Id.class)
    private String id;
    @JsonView(Views.IdName.class)
    private String name;
    @JsonView(Views.IdName.class)
    private String userpic;
    private String email;
    @JsonView(Views.FullProfile.class)
    private String gender;
    @JsonView(Views.FullProfile.class)
    private String locale;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullProfile.class)
    private LocalDateTime lastVisit;

    @JsonView(Views.FullProfile.class)
    @OneToMany(
            mappedBy = "subscriber",
            orphanRemoval = true //При удалении пользователя удаляются и все связанные с ним записи в базе
    )
    private Set<UserSubscription> subscriptions = new HashSet<>();

    @JsonView(Views.FullProfile.class)
    @OneToMany(
            mappedBy = "channel",
            orphanRemoval = true, //При удалении пользователя удаляются и все связанные с ним записи в базе
            cascade = CascadeType.ALL
    )
    private Set<UserSubscription> subscribers = new HashSet<>();


}
