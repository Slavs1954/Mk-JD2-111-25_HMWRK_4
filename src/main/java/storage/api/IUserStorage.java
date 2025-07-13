package storage.api;

import dto.User;

import java.util.List;

public interface IUserStorage {
    void add(User user);
    User getUser(String username, String password);
    boolean isValidUser(String username, String password);
    List<User> getAll();
    int getUserCount();
    List<String> getOtherUsernames(String username);
    boolean isAdmin(String username);
}
