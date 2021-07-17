package by.zhenekns.dao;

import by.zhenekns.dao.database.DatabaseDAO;
import by.zhenekns.dao.database.DatabaseDAOImpl;
import by.zhenekns.dao.user.UserDAO;
import by.zhenekns.dao.user.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory(){}

    private DatabaseDAO databaseDAO = new DatabaseDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();

    public DatabaseDAO getDatabaseDAO() {
        return databaseDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
