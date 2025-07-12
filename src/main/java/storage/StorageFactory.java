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
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("org.postgresql.Driver");
            cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/auth");
            cpds.setUser("postgres");
            cpds.setPassword("postgres");

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
