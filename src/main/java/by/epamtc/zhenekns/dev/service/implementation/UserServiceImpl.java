package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(int id) {
        User user = new User();
        ResultSet resultSet = null;
        String email = "",
                password = "",
                nickname = "",
                role = "";


        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from users where id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            email = resultSet.getString("user_email");
            password = resultSet.getString("user_password");
            nickname = resultSet.getString("user_nickname");
            role = resultSet.getString("user_role");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new User(id, email, password, nickname, Role.valueOf(role));
    }

    @Override
    public User getUserByEmailPassword(String email, String password) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users where user_email=? and user_password=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = getUser(resultSet);
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
        return user;
    }

    @Override
    public boolean checkUser(String username, String email) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        User user = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users where user_nickname=? or user_email=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
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
        return false;
    }

    private static User getUser(ResultSet resultSet) {
        User user = new User();
        try {
            int id = resultSet.getInt("id");
            String email = resultSet.getString("user_email");
            String username = resultSet.getString("user_nickname");
            String password = resultSet.getString("user_password");
            String role = resultSet.getString("user_role");
            Role userRole = Role.valueOf(role.toUpperCase());
            user = new User(id, email, password, username, userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("user_email"));
                user.setNickname(resultSet.getString("user_nickname"));
                user.setPassword(resultSet.getString("user_password"));
                Role role = Role.valueOf(resultSet.getString("user_role"));
                user.setRole(role);

                users.add(user);
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
        return users;
    }

    @Override
    public Role getRoleByUsernamePassword(String username, String password) {
        return null;
    }

    @Override
    public UserInfo getAllInfoAboutUserById(int id) {
        User user = new User();
        UserInfo userInfo = new UserInfo();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_info where user_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userInfo.setId(resultSet.getInt("id"));
                userInfo.setQualification(resultSet.getString("qualifications"));
                userInfo.setStatus(resultSet.getString("status"));
                userInfo.setExperience(resultSet.getString("experience"));
                userInfo.setCity(resultSet.getString("city"));
                userInfo.setCountry(resultSet.getString("country"));
                userInfo.setSocialLink(resultSet.getString("link_to_social_network"));
                userInfo.setDateOfRegistration(resultSet.getString("date_of_birth"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public List<User> getAllUserByRole(Role role) {
        List<User> users = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users where user_role = ? order by id desc");
            preparedStatement.setString(1, role.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                int userId = resultSet.getInt("id");
                UserInfo userInfo = getAllInfoAboutUserById(userId);
                user.setRole(Role.valueOf(resultSet.getString("user_role")));
                user.setEmail(resultSet.getString("user_email"));
                user.setNickname(resultSet.getString("user_nickname"));
                user.setPassword(resultSet.getString("user_password"));
                user.setId(userId);
                user.setUserInfo(userInfo);
                //System.out.println(user);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
