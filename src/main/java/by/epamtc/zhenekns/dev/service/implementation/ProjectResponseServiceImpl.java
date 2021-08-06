package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.ProjectResponseDAO;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectResponseService;

import java.util.List;

public class ProjectResponseServiceImpl implements ProjectResponseService {

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final ProjectResponseDAO projectServiceResponseDao = daoFactory.getProjectResponseDAO();

    @Override
    public ProjectResponse addProjectResponse(ProjectResponse projectResponse) throws ServiceException {
        try {
            return projectServiceResponseDao.addProjectResponse(projectResponse);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public ProjectResponse cancelProjectResponse(ProjectResponse projectResponse) throws ServiceException {
        return null;
    }

    @Override
    public ProjectResponse updateProjectResponse(ProjectResponse projectResponse) throws ServiceException {
        return null;
    }

    @Override
    public List<ProjectResponse> getProjectResponsesByResponderId(int id) throws ServiceException {
        try {
            return projectServiceResponseDao.getProjectResponsesByResponderId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
