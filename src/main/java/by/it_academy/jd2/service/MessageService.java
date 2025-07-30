package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.storage.api.IMessageStorage;

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
    public int getMessageCount() {
        return messageStorage.getMessageCount();
    }

    @Override
    public void sendMessage(Message message) {
        messageStorage.add(message);
    }
}
