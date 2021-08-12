package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    Map<Project, User> getAllProjects() throws ServiceException;
    Project addNewProject(Project project) throws ServiceException;
    Project getProjectById(int id) throws ServiceException;
    List<Project> getProjectsByUserId(int id) throws ServiceException;
    Project updateProjectDetails(Project project) throws ServiceException;

    Map<Project, User> getAllProjectsByStatus(String status) throws ServiceException;
    void updateProjectStatusById(String status, int id) throws ServiceException;

}
