package by.zhenekns.dao.user;

import by.zhenekns.entity.Role;
import by.zhenekns.entity.User;

public interface UserDAO {
    User getUserById(int id);
    User getUserByUsernamePassword(String username, String password);
    Role getRoleByUsernamePassword(String username, String password);
    boolean isUserExists(String email, String username, String password);
}
