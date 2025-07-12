package storage;

import dto.ERole;
import dto.User;
import storage.api.IUserStorage;
import storage.api.exceptions.StorageException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserStorageSQL implements IUserStorage {
    private final DataSource dataSource;

    public UserStorageSQL(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void add(User user) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                         INSERT INTO auth_app.users(
                         	username, password, full_name, birth_date, registration_date, role)
                         	VALUES (?, ?, ?, ?, ?, ?);
                     """)
        ) {
            statement.setObject(1, user.getUsername());
            statement.setObject(2, user.getPassword());
            statement.setObject(3, user.getFullName());
            statement.setObject(4, user.getBirthDate());
            statement.setObject(5, user.getRegistrationDateTime());
            statement.setObject(6, user.getRole().toString());

            statement.executeUpdate();
        } catch (Exception e) {
            throw new StorageException("ERR: USER ADDITION FAILED", e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                             SELECT username, password, full_name, birth_date, registration_date, role
                             	FROM auth_app.users;
                     """);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                result.add(User.builder()
                        .username(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .fullName(resultSet.getString("full_name"))
                        .birthDate(resultSet.getObject("birth_date", LocalDate.class))
                        .registrationDate(resultSet.getObject("registration_date", LocalDateTime.class))
                        .role(resultSet.getObject("role", ERole.class))
                        .build());
            }

        } catch (SQLException e) {
            throw new StorageException("ERR: FAILED TO RETRIEVE USERS", e);
        }
        return result;
    }

    @Override
    public User getUser(String username, String password) {
        User result = null;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                             SELECT username, password, full_name, birth_date, registration_date, role
                             	FROM auth_app.users
                             WHERE username = ? AND password = ?;
                     """);
             ) {
            statement.setObject(1, username);
            statement.setObject(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = User.builder()
                            .username(resultSet.getString("username"))
                            .password(resultSet.getString("password"))
                            .fullName(resultSet.getString("full_name"))
                            .birthDate(resultSet.getObject("birth_date", LocalDate.class))
                            .registrationDate(resultSet.getObject("registration_date", LocalDateTime.class))
                            .role(resultSet.getObject("role", ERole.class))
                            .build();
                }
            }


        } catch (SQLException e) {
            throw new StorageException("ERR: FAILED TO RETRIEVE USER", e);
        }
        return result;
    }

    @Override
    public boolean isValidUser(String username, String password) {
        User result = null;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                             SELECT username, password, full_name, birth_date, registration_date, role
                             	FROM auth_app.users
                             WHERE username = ? AND password = ?;
                     """);
        ) {
            statement.setObject(1, username);
            statement.setObject(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }


        } catch (SQLException e) {
            throw new StorageException("ERR: FAILED TO RETRIEVE USER", e);
        }
    }
}
