package by.zhenekns.dao.user;

import by.zhenekns.dao.database.ConnectionPool;
import by.zhenekns.entity.Role;
import by.zhenekns.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByUsernamePassword(String username, String password) {
        return null;
    }

    @Override
    public Role getRoleByUsernamePassword(String username, String password) {
        return null;
    }

    @Override
    public boolean isUserExists(String email, String username, String password) {
        boolean isUserExists = false;

        return isUserExists;
    }
}
