package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;

public interface ProjectResponseService {

    ProjectResponse addProjectResponse(ProjectResponse projectResponse)throws ServiceException;
    ProjectResponse cancelProjectResponse(ProjectResponse projectResponse) throws ServiceException;
    ProjectResponse updateProjectResponse(ProjectResponse projectResponse) throws ServiceException;
    List<ProjectResponse> getProjectResponsesByResponderId(int id) throws ServiceException;
    ProjectResponse getProjectResponseById(int id) throws ServiceException;
    List<ProjectResponse> getProjectResponsesByOwnerId(int id) throws ServiceException;
    List<ProjectResponse> getProjectResponsesByResponderIdAndAvoidStatus(String status, int id) throws ServiceException;
    List<ProjectResponse> getProjectResponsesByResponderIdAndStatus(String status, int id) throws ServiceException;
    void updateProjectResponseStatusById(String status, int id) throws ServiceException;
}
