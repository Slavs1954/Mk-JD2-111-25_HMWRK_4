package by.it_academy.jd2.service;

import by.it_academy.jd2.core.ContextFactory;
import by.it_academy.jd2.listener.UserCounterListener;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.storage.api.IUserStorage;

public class StatService implements IStatService {

    private final IUserStorage userStorage;
    StatService(IUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public int getActiveUsers() {
        return UserCounterListener.getActiveUsers();
    }
    public int getUserCount() {
        return userStorage.count();
    }
}
