package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.core.dto.ERole;
import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.service.api.IAuthService;
import by.it_academy.jd2.storage.api.IUserStorage;

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
    public boolean authenticate(String username, String password) {
        return userStorage.isValidUser(username, password);
    }

    @Override
    public AuthUser getAuthUser(String username, String password) {
        return userStorage.getAuthUser(username, password);
    }

    @Override
    public boolean isAdmin(AuthUser user) {
        return user.getRole() == ERole.ADMIN;
    }

    @Override
    public List<String> getOtherUsernames(String username) {
        return userStorage.getOtherUsernames(username);
    }

}
