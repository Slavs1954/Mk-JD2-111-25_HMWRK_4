package storage;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import service.api.IAuthService;
import storage.api.IMessageStorage;
import storage.api.IUserStorage;
import storage.api.exceptions.StorageException;

import javax.sql.DataSource;

public class StorageFactory {

    private StorageFactory() {

    }
    private final static DataSource dataSource;
    static {

        String dbUrl = System.getenv("DB_URL");
        if (dbUrl == null || dbUrl.isEmpty()) {
            dbUrl = "jdbc:postgresql://localhost:5432/auth";
        }
        String dbUser = System.getenv("DB_USER");
        if (dbUser == null || dbUser.isEmpty()) {
            dbUser = "postgres";
        }
        String dbPassword = System.getenv("DB_PASSWORD");
        if (dbPassword == null || dbPassword.isEmpty()) {
            dbPassword = "postgres";
        }

        try {

            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("org.postgresql.Driver");
            cpds.setJdbcUrl(dbUrl);
            cpds.setUser(dbUser);
            cpds.setPassword(dbPassword);

            dataSource = cpds;
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private final static IUserStorage userStorage = new UserStorageSQL(dataSource);
    private final static IMessageStorage messageStorage = new MessageStorageSQL(dataSource);

    public static IUserStorage getUserStorage() {
        return userStorage;
    }
    public static IMessageStorage getMessageStorage() {
        return messageStorage;
    }
}
