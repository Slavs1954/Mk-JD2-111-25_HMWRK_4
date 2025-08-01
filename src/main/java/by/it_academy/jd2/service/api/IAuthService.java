package by.it_academy.jd2.service.api;

import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.validation.api.exceptions.ValidationException;

import java.util.List;

public interface IAuthService {
    void add(User user) throws ValidationException;
    List<User> getUserInfo();
    boolean authenticate(String username, String password);
    List<String> getOtherUsernames(String username);
    AuthUser getAuthUser(String username, String password);
    boolean isAdmin (AuthUser user);
}
