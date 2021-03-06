package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.util.List;

public interface TaskDAO {

    Task addTask(Task task) throws DaoException;
    void updateTask(String name, String description, int id) throws DaoException;
    Task deleteTask(Task task) throws DaoException;
    List<Task> getTasksByManagerId(int id) throws DaoException;
    List<Task> getTasksByDeveloperId(int id) throws DaoException;
    Task getTaskById(int id) throws DaoException;
    List<Task> getTasksByTeamId(int id) throws DaoException;
    void deleteTaskById(int taskId) throws DaoException;
    void updateTaskStatusById(int id, String status) throws DaoException;

}
