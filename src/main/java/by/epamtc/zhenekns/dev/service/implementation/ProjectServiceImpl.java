package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.ProjectDAO;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;

import java.util.List;
import java.util.Map;

public class ProjectServiceImpl implements ProjectService {
    private static final ProjectDAO projectDao = DAOFactory.getInstance().getProjectDAO();

    @Override
    public Project addNewProject(Project project) throws ServiceException {
        return projectDao.addNewProject(project);
    }

    @Override
    public Map<Project, User> getAllProjects() throws ServiceException {
        try {
            return projectDao.getAllProjects();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Project getProjectById(int id) throws ServiceException {
        try {
            return projectDao.getProjectById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Project> getProjectsByUserId(int id) throws ServiceException {
        try {
            return projectDao.getProjectsByUserId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
