package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.dao.implementation.*;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    private final UserDAO userDAO = new UserDAOImpl();
    private final ProjectDAO projectDAO = new ProjectDAOImpl();
    private final ProjectResponseDAO projectResponseDAO = new ProjectResponseDAOImpl();
    private final TeamDAO teamDAO = new TeamDAOImpl();
    private final TaskDAO taskDAO = new TaskDAOImpl();

    public ProjectResponseDAO getProjectResponseDAO() {
        return projectResponseDAO;
    }

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TeamDAO getTeamDAO() {
        return teamDAO;
    }

    public TaskDAO getTaskDAO() {
        return taskDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
