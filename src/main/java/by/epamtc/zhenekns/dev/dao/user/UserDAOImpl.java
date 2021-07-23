package by.epamtc.zhenekns.dev.dao.user;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {


    @Override
    public User addUser(User user) {
        user = executeSQL("INSERT INTO users VALUES (?,?,?,?,?)");
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

    private static User executeSQL(String SQL){
        User user = User.getInstance();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getNickname());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public int getLastId(){
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        int a = 0;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) FROM `users`");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            a = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return a;
    }


}
