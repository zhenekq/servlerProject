package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;

public interface UserService {


    //refactored
    User getUserById(int id) throws ServiceException;
    boolean checkUser(String username, String email) throws ServiceException;
    List<User> getAllUsersByRole(Role role) throws ServiceException;
    User updateUser(User user) throws ServiceException;
    int getLastIdInfo() throws ServiceException;
    UserInfo addAdditionalInfo(UserInfo userInfo) throws ServiceException;
    int getLastId() throws ServiceException;
    UserInfo getAllInfoAboutUserById(int id) throws ServiceException;
    User loginUser(String email, String password) throws ServiceException;
    User authorizationUser(User user) throws ServiceException;
}
