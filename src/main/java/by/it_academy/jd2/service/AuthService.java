package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.core.dto.ERole;
import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.service.api.IAuthService;
import by.it_academy.jd2.storage.api.IUserStorage;
import by.it_academy.jd2.validation.api.IValidator;
import by.it_academy.jd2.validation.api.exceptions.ValidationException;

import java.util.List;

public class AuthService implements IAuthService {

    private final IUserStorage userStorage;
    private final IValidator<User> userIValidator;
    private final IValidator<AuthUser> authUserIValidator;

    public AuthService(IUserStorage userStorage, IValidator<User> userIValidator,  IValidator<AuthUser> authUserIValidator) {
        this.userStorage = userStorage;
        this.userIValidator = userIValidator;
        this.authUserIValidator = authUserIValidator;
    }

    @Override
    public void add(User user) throws ValidationException {
        if (userIValidator != null) {
            userIValidator.validateOrThrow(user);
        }
        this.userStorage.add(user);
    }

    @Override
    public List<User> getUserInfo() {
        return userStorage.getAll();
    }
    @Override
    public boolean authenticate(String username, String password) {
        return authUserIValidator.validate(userStorage.getAuthUser(username, password)).isValid();
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
