package repository.db;

import config.DbProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnectionFactory {

    private Connection connection;
    private static DbConnectionFactory instance;

    private DbConnectionFactory() {
    }

    public static DbConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DbConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            DbProperties dbp=new DbProperties();
            String url = dbp.returnDbURL();
            String username = dbp.returnDbUser();
            String password =dbp.returnDbPassword();
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
