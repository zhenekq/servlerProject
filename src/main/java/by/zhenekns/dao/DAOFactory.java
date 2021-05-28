package by.zhenekns.dao;

import by.zhenekns.dao.database.DatabaseDAO;
import by.zhenekns.dao.database.MysqlDAO;
import by.zhenekns.dao.user.SQLUserDAO;
import by.zhenekns.dao.user.UserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory(){}

    private final UserDAO userDAO = new SQLUserDAO();
    private final DatabaseDAO databaseDAO = new MysqlDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public DatabaseDAO getDatabaseDAO() {
        return databaseDAO;
    }
}
