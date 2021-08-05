package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;

public interface ProjectResponseService {

    ProjectResponse addProjectResponse(ProjectResponse projectResponse)throws ServiceException;
    ProjectResponse cancelProjectResponse(ProjectResponse projectResponse) throws ServiceException;
    ProjectResponse updateProjectResponse(ProjectResponse projectResponse) throws ServiceException;
}
