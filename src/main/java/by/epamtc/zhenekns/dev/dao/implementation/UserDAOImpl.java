package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.UserDAO;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.status.UserStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {


    @Override
    public User addUser(User user) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(?,?,?,?,?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getNickname());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.executeUpdate();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getId());
            userInfo.setId(user.getId());
            userInfo.setStatus(UserStatus.USER_STATUS_FREE);
            addAdditionalInfo(userInfo);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return user;
    }

    @Override
    public User updateUser(User user) throws DaoException {
        UserInfo userInfo = user.getUserInfo();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE user_info set qualifications = ?, experience=?, city=?, country=?," +
                            "link_to_social_network=?, date_of_birth=? where id=?");
            preparedStatement.setString(1, userInfo.getQualification());
            preparedStatement.setString(2, userInfo.getExperience());
            preparedStatement.setString(3, userInfo.getCity());
            preparedStatement.setString(4, userInfo.getCountry());
            preparedStatement.setString(5, userInfo.getSocialLink());
            preparedStatement.setString(6, userInfo.getDateOfRegistration());
            preparedStatement.setInt(7, userInfo.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public UserInfo addAdditionalInfo(UserInfo userInfo) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user_info VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, userInfo.getId());
            preparedStatement.setString(2, userInfo.getQualification());
            preparedStatement.setString(3, userInfo.getStatus());
            preparedStatement.setString(4, userInfo.getExperience());
            preparedStatement.setString(5, userInfo.getCity());
            preparedStatement.setString(6, userInfo.getCountry());
            preparedStatement.setString(7, userInfo.getSocialLink());
            preparedStatement.setString(8, userInfo.getDateOfRegistration());
            preparedStatement.setInt(9, userInfo.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userInfo;
    }

    public int getLastId() throws DaoException {
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
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return a;
    }

    @Override
    public int getLastIdInfo() throws DaoException {
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return a;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) throws DaoException {
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
                throw new DaoException(e);
            }
        }
        return user;
    }

    private static User getUser(ResultSet resultSet) throws DaoException {
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
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public UserInfo getAllInfoAboutUserById(int id) throws DaoException {
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
                userInfo.setUserId(resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userInfo;
    }

    @Override
    public List<User> getAllUsersByRole(Role role) throws DaoException {
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
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public User getUserById(int id) throws DaoException {
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
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return new User(id, email, password, nickname, Role.valueOf(role));
    }

    @Override
    public boolean checkUser(String username, String email) throws DaoException {
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

    @Override
    public void updateUserStatusById(int id, String status) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE user_info set status = ? where user_id = ?"
            );
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        List<User> users = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users order by id desc"
            );
            ResultSet resultSet = statement.executeQuery();
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
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public List<User> getUsersByTag(String tag) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT * FROM users where user_nickname like '%" + tag + "%'");
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
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }

}
