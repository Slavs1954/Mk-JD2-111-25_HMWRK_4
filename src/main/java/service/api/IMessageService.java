package service.api;

import dto.Message;

import java.util.List;

public interface IMessageService {
    void sendMessage(Message message);
    List<Message> getUserMessages(String username);
    int getMessageCount();
}
