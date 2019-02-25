package messenger.domain;

/*
Класс для сокрытия некоторых полей
 */
public final class Views {
    public interface Id{}

    public interface IdName extends Id{}

    public interface FullMessage extends IdName{}
}
