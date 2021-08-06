package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;

public interface ProjectResponseService {

    ProjectResponse addProjectResponse(ProjectResponse projectResponse)throws ServiceException;
    ProjectResponse cancelProjectResponse(ProjectResponse projectResponse) throws ServiceException;
    ProjectResponse updateProjectResponse(ProjectResponse projectResponse) throws ServiceException;
    public List<ProjectResponse> getProjectResponsesByResponderId(int id) throws ServiceException;
}
