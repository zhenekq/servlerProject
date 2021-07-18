package by.epamtc.zhenekns.dev.service.user;

import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;

public interface UserService {

    User getUserById(int id);
    User getUserByEmailPassword(String username, String password);
    boolean checkUser(String username, String email);
    Role getRoleByUsernamePassword(String username, String password);

}
