package service.api;

import dto.Message;

import java.util.List;

public interface IMessageService {
    public void sendMessage(Message message);
    public List<Message> getUserMessages(String username);
}
