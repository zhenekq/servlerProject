package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;

public interface TaskService {

    Task addTask(Task task) throws ServiceException;
    void updateTaskById(String name, String description, int id) throws ServiceException;
    Task deleteTask(Task task) throws ServiceException;
    List<Task> getTasksByManagerId(int id) throws ServiceException;
    List<Task> getTasksByDeveloperId(int id) throws ServiceException;
    Task getTaskById(int id) throws ServiceException;
    List<Task> getTasksByTeamId(int id) throws ServiceException;


}
