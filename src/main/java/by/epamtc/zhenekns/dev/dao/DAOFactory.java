package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.dao.user.UserDAO;
import by.epamtc.zhenekns.dev.dao.user.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    private UserDAO userDAO = new UserDAOImpl();


    public UserDAO getUserDAO() {
        return userDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
