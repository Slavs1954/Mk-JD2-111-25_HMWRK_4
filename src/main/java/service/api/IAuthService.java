package service.api;

import dto.User;

import java.util.List;

public interface IAuthService {
    void add(User user);
    List<User> getUserInfo();
    boolean authenticateUser(String username, String password);
    int getUserCount();
    List<String> getOtherUsernames(String username);
    boolean isAdmin(String username);
}
