package storage.api;

import dto.Message;

import java.util.List;

public interface IMessageStorage {

    public void add(Message message);
    public List<Message> getUserMessages(String username);
}
