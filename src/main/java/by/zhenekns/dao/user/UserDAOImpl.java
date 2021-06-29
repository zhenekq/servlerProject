package by.zhenekns.dao.user;

import by.zhenekns.entity.Role;
import by.zhenekns.entity.User;

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
    public boolean isUserExists(String username, String password) {
        return false;
    }
}
