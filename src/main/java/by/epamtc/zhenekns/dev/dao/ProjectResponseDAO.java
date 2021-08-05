package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;

public interface ProjectResponseDAO {

    ProjectResponse addProjectResponse(ProjectResponse projectResponse) throws DaoException;
    ProjectResponse cancelProjectResponse(ProjectResponse projectResponse) throws DaoException;
    ProjectResponse updateProjectResponse(ProjectResponse projectResponse) throws DaoException;
    ProjectResponse getProjectResponseByResponderId(int id) throws DaoException;


}
