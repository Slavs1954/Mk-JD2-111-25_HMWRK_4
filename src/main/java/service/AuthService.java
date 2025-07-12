package service;

import dto.User;
import service.api.IAuthService;
import storage.api.IUserStorage;

import java.util.List;

public class AuthService implements IAuthService {

    private final IUserStorage userStorage;

    public AuthService(IUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public void add(User user) {
        this.userStorage.add(user);
    }

    @Override
    public List<User> getUserInfo() {
        return userStorage.getAll();
    }
    @Override
    public boolean authenticateUser(String username, String password) {
        if (userStorage.isValidUser(username, password)) {
            return true;
        };
        return false;
    }
}
