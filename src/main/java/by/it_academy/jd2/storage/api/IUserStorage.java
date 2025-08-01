package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.dto.AuthUser;
import by.it_academy.jd2.core.dto.User;

import java.util.List;

public interface IUserStorage {
    void add(User user);
    User getUser(String username, String password);
    AuthUser getAuthUser(String username, String password);
    List<User> getAll();

    /**
     * Returns the number of users stored in the database.
     *
     * <p>Returns {@code -1} if something goes wrong but no exception is thrown.</p>
     *
     * @return the number of users, or {@code -1} if an unknown error occurs
     *
     * @throws by.it_academy.jd2.storage.api.exceptions.StorageException
     * if there is a problem retrieving data from the storage
     */

    int count();
    List<String> getOtherUsernames(String username);
}
