package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.dto.Message;

import java.util.List;

public interface IMessageStorage {

    void add(Message message);
    List<Message> getUserMessages(String username);
    int getMessageCount();
}
