package messenger.domain;

/**
Класс для сокрытия некоторых полей от клиента
 */
public final class Views {
    //Показывает только id клиенту
    public interface Id {
    }
    //Показывает и id и name
    public interface IdName extends Id {
    }
    //Показывает комментарий (и id и name)
    public interface FullComment extends IdName {
    }
    //Показывает сообщение (и id и name)
    public interface FullMessage extends IdName {
    }
    //Показывает профиль (и id и name)
    public interface FullProfile extends IdName{

    }
}
