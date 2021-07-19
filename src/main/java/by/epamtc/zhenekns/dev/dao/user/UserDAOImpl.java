package by.epamtc.zhenekns.dev.dao.user;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {


    @Override
    public User addUser(User user) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getNickname());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
