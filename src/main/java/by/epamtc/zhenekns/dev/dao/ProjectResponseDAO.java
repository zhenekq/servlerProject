package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.util.List;

public interface ProjectResponseDAO {

    ProjectResponse addProjectResponse(ProjectResponse projectResponse) throws DaoException;
    ProjectResponse cancelProjectResponse(ProjectResponse projectResponse) throws DaoException;
    ProjectResponse updateProjectResponse(ProjectResponse projectResponse) throws DaoException;
    List<ProjectResponse> getProjectResponsesByResponderId(int id) throws DaoException;
    ProjectResponse getProjectResponseById(int id) throws DaoException;
    List<ProjectResponse> getProjectResponsesByOwnerId(int id) throws DaoException;
    List<ProjectResponse> getProjectResponsesByResponderIdAndAvoidStatus(String status, int id) throws DaoException;
    List<ProjectResponse> getProjectResponsesByResponderIdAndStatus(String status, int id) throws DaoException;
    void updateProjectResponseStatusById(String status, int id) throws DaoException;
}
