package service;

import service.api.IAuthService;
import service.api.IMessageService;
import storage.StorageFactory;

public class ServiceFactory {
    private static final IAuthService authService = new AuthService(StorageFactory.getUserStorage());
    private static final IMessageService messageService = new MessageService(StorageFactory.getMessageStorage());
    private ServiceFactory() {}

    public static IAuthService getAuthService() {
        return authService;
    }
    public static IMessageService getMessageService() {
        return messageService;
    }


}
