package by.zhenekns.dao;

import by.zhenekns.dao.database.DatabaseDAO;
import by.zhenekns.dao.database.DatabaseDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory(){}

    private DatabaseDAO databaseDAO = new DatabaseDAOImpl();

    public DatabaseDAO getDatabaseDAO() {
        return databaseDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
