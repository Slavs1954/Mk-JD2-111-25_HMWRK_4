package storage;

import dto.ERole;
import dto.Message;
import dto.User;
import storage.api.IMessageStorage;
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

public class MessageStorageSQL implements IMessageStorage {

    private final DataSource dataSource;

    public MessageStorageSQL(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void add(Message message) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                     INSERT INTO auth_app.messages(
                     	sender, receiver, message, dt_send)
                     	VALUES (?, ?, ?, ?);
                     """)
        ) {
            statement.setString(1, message.getSender());
            statement.setString(2, message.getReceiver());
            statement.setString(3, message.getMessage());
            statement.setObject(4, message.getDtSend());

            statement.executeUpdate();
        } catch (Exception e) {
            throw new StorageException("ERR: MESSAGE ADDITION FAILED", e);
        }
    }

    @Override
    public List<Message> getUserMessages(String username) {
        List<Message> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                     SELECT sender, receiver, message, dt_send
                         FROM auth_app.messages
                     WHERE receiver = ?
                     """)
        ) {

            statement.setString(1, username);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(Message.builder()
                            .sender(resultSet.getString("sender"))
                            .receiver(resultSet.getString("receiver"))
                            .message(resultSet.getString("message"))
                            .dtSend(resultSet.getObject("dt_send", LocalDateTime.class))
                            .build());
                }
            }

        } catch (SQLException e) {
            throw new StorageException("ERR: FAILED TO RETRIEVE MESSAGES FOR " + username, e);
        }
        return result;
    }

    @Override
    public int getMessageCount() {
        List<User> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                             SELECT Count(*)
                             	FROM auth_app.messages;
                     """);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new StorageException("ERR: FAILED TO COUNT MESSAGES", e);
        }
        return -1;
    }
}
