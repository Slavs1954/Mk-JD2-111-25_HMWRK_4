package storage.api;

import dto.Message;

import java.util.List;

public interface IMessageStorage {

    void add(Message message);
    List<Message> getUserMessages(String username);
    int getMessageCount();
}
