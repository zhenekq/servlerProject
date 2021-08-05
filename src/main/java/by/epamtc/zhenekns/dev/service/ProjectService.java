package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    Map<Project, User> getAllProjects() throws ServiceException;
    Project addNewProject(Project project) throws ServiceException;
    Project getProjectById(int id) throws ServiceException;
    List<Project> getProjectsByUserId(int id) throws ServiceException;

}
