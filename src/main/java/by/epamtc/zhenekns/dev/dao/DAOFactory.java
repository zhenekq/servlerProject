package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.dao.implementation.ProjectDAOImpl;
import by.epamtc.zhenekns.dev.dao.implementation.ProjectResponseImpl;
import by.epamtc.zhenekns.dev.dao.implementation.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    private final UserDAO userDAO = new UserDAOImpl();
    private final ProjectDAO projectDAO = new ProjectDAOImpl();
    private final ProjectResponseDAO projectResponseDAO = new ProjectResponseImpl();

    public ProjectResponseDAO getProjectResponseDAO() {
        return projectResponseDAO;
    }

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
