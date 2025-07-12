package service;

import dto.Message;
import service.api.IMessageService;
import storage.api.IMessageStorage;

import java.util.List;

public class MessageService implements IMessageService {

    private final IMessageStorage messageStorage;

    MessageService(IMessageStorage messageStorage) {
        this.messageStorage = messageStorage;
    }

    @Override
    public List<Message> getUserMessages(String username) {
        return messageStorage.getUserMessages(username);
    }

    @Override
    public void sendMessage(Message message) {
        messageStorage.add(message);
    }
}
