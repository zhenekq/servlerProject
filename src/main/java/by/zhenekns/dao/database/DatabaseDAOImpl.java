package by.zhenekns.dao.database;

import by.zhenekns.entity.User;
import by.zhenekns.util.DatabaseUtil;

import java.sql.*;

public class DatabaseDAOImpl implements DatabaseDAO {

    @Override
    public void add(User user) {
        DatabaseUtil.executeSQL("INSERT INTO users (user_email, user_nickname, user_password, user_role) " +
                "VALUES ('" + user.getEmail() + "', '" + user.getNickname() + "', '" + user.getPassword() + "','" + user.getRole() + "')");
    }

    @Override
    public boolean isUserExists(User user) {
        return true;
    }
}
