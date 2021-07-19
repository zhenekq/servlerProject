package by.epamtc.zhenekns.dev.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;

public class ConnectionPool {

    private static ConnectionPool connectionPool;
    private static FileInputStream path = null;

    private static final String BASIC_SQL_REQUEST = "select 1";

    private String url;
    private String username;
    private String password;
    private String driverName;

    private static final int MAX_POOL_SIZE = 15;
    private int connNum = 0;

    private Stack<Connection> freePool = new Stack<>();
    private Set<Connection> occupiedConnections = new HashSet<>();

    private ConnectionPool() {
        ClassLoader classLoader = getClass().getClassLoader();
        Properties dbProperties = new Properties();
        String pathToProperties = "db.properties";
        InputStream path = classLoader.getResourceAsStream(pathToProperties);
        try {
            dbProperties.load(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.url = dbProperties.getProperty("db.url");
        this.username = dbProperties.getProperty("db.username");
        this.password = dbProperties.getProperty("db.password");
        this.driverName = dbProperties.getProperty("db.driver");
    }

    public static ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        if (isFull()) {
            throw new SQLException("Connection pool is full!");
        }
        connection = getConnectionFromPool();
        if (connection == null) {
            connection = createNewConnectionForPool();
        }
        connection = makeAvailable(connection);
        return connection;
    }

    public void returnConnection(Connection connection) throws SQLException {
        if (connection == null) {
            throw new NullPointerException();
        }
        if (!occupiedConnections.remove(connection)) {
            throw new SQLException("The connection is already or it isn't for this pool");
        }
        freePool.add(connection);
    }

    private boolean isFull() {
        return ((freePool.size() == 0) && (connNum >= MAX_POOL_SIZE));
    }

    private Connection createNewConnectionForPool() {
        Connection connection = createNewConnection();
        connNum++;
        occupiedConnections.add(connection);
        return connection;
    }

    private Connection createNewConnection() {
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Connection getConnectionFromPool() {
        Connection connection = null;
        if (freePool.size() > 0) {
            connection = freePool.pop();
            occupiedConnections.add(connection);
        }
        return connection;
    }

    private Connection makeAvailable(Connection connection) {
        if (isConnectionAvailable(connection)) {
            return connection;
        }
        occupiedConnections.remove(connection);
        connNum--;
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = createNewConnection();
        occupiedConnections.add(connection);
        connNum++;
        return connection;
    }

    private boolean isConnectionAvailable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(BASIC_SQL_REQUEST);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
