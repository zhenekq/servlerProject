package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;

import java.util.List;

public interface UserService {

    UserInfo getAllInfoAboutUserById(int id);
    User getUserById(int id);
    User getUserByEmailPassword(String username, String password);
    boolean checkUser(String username, String email);
    Role getRoleByUsernamePassword(String username, String password);
    List<User> getAllUsers();
    List<User> getAllUserByRole(Role role);

}
