package by.zhenekns.dao.database;

import by.zhenekns.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAOImpl implements DatabaseDAO {

    private static final String SQL_ADD_USER_BY_EMAIL_NICK_PASSWORD = "";

    @Override
    public void add(User user) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO users (user_email, user_nickname, user_password, user_role) " +
                        "VALUES ('" + user.getEmail() + "', '" + user.getNickname() + "', '" + user.getPassword() + "','" + user.getRole() + "')");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(User user) {

    }
}
