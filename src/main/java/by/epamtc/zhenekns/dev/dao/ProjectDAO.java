package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface ProjectDAO {

    Project addNewProject(Project project) throws DaoException;
    Project updateProject(Project project) throws DaoException;
    Map<Project, User> getAllProjects() throws DaoException;
    List<Project> getProjectsByUserId(int id) throws DaoException;
    Project getProjectById(int id) throws DaoException;
    Map<Project, User> getAllProjectsByStatus(String status) throws DaoException;

    void updateProjectStatusById(String status, int id) throws DaoException;
}
