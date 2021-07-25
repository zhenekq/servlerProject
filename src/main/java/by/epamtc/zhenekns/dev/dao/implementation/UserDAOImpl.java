package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.SQLRequest;
import by.epamtc.zhenekns.dev.dao.UserDAO;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;

import java.sql.*;

public class UserDAOImpl implements UserDAO {


    @Override
    public User addUser(User user) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLRequest.ADD_NEW_USER);
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



    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public UserInfo addAdditionalInfo(UserInfo userInfo) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user_info VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, userInfo.getId());
            preparedStatement.setString(2,userInfo.getQualification());
            preparedStatement.setString(3,userInfo.getStatus());
            preparedStatement.setString(4,userInfo.getExperience());
            preparedStatement.setString(5,userInfo.getCity());
            preparedStatement.setString(6,userInfo.getCountry());
            preparedStatement.setString(7,userInfo.getSocialLink());
            preparedStatement.setString(8,userInfo.getDateOfRegistration());
            preparedStatement.setInt(9, User.getInstance().getId());

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
        return userInfo;
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

    public int getLastIdInfo(){
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        int a = 0;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) FROM `user_info`");
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
