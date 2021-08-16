package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.UserDAO;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final UserDAO userDAO = daoFactory.getUserDAO();

    //REFACTORED------------------------------------------------------------------------------

    @Override
    public User getUserById(int id) throws ServiceException {
        try {
            return userDAO.getUserById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean checkUser(String username, String email) throws ServiceException {
        try {
            return userDAO.checkUser(username, email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsersByRole(Role role) throws ServiceException {
        try {
            return userDAO.getAllUsersByRole(role);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getLastId() throws ServiceException {
        int lastId = 0;
        try {
            lastId = userDAO.getLastId();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return lastId;
    }

    @Override
    public int getLastIdInfo() throws ServiceException {
        try {
            return userDAO.getLastIdInfo();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User loginUser(String email, String password) throws ServiceException {
        try {
            return userDAO.findUserByEmailAndPassword(email, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User authorizationUser(User user) throws ServiceException {
        try {
            user = userDAO.addUser(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public UserInfo getAllInfoAboutUserById(int id) throws ServiceException {
        try {
            return userDAO.getAllInfoAboutUserById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public UserInfo addAdditionalInfo(UserInfo userInfo) throws ServiceException {
        try {
            return userDAO.addAdditionalInfo(userInfo);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User updateUser(User user) throws ServiceException {
        try {
            return userDAO.updateUser(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserStatusById(int id, String status) throws ServiceException {
        try {
            userDAO.updateUserStatusById(id, status);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDAO.getAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsersByTag(String tag) throws ServiceException {
        try {
            return userDAO.getUsersByTag(tag);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
