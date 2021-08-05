package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.util.List;

public interface UserDAO {
    
    User addUser(User user) throws DaoException;
    int getLastIdInfo() throws DaoException;
    User updateUser(User user) throws DaoException;
    UserInfo addAdditionalInfo(UserInfo userInfo) throws DaoException;
    UserInfo getAllInfoAboutUserById(int id) throws DaoException;
    int getLastId() throws DaoException;
    User findUserByEmailAndPassword(String email, String password) throws DaoException;
    List<User> getAllUsersByRole(Role role) throws DaoException;
    User getUserById(int id) throws DaoException;
    boolean checkUser(String username, String email) throws DaoException;

}
