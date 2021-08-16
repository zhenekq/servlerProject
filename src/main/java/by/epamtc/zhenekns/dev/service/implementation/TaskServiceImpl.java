package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.TaskDAO;
import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO = DAOFactory.getInstance().getTaskDAO();

    @Override
    public Task addTask(Task task) throws ServiceException {
        try {
            return taskDAO.addTask(task);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Task updateTask(Task task) throws ServiceException {
        return null;
    }

    @Override
    public Task deleteTask(Task task) throws ServiceException {
        return null;
    }

    @Override
    public List<Task> getTasksByManagerId(int id) throws ServiceException {
        return null;
    }

    @Override
    public List<Task> getTasksByDeveloperId(int id) throws ServiceException {
        return null;
    }

    @Override
    public Task getTaskById(int id) throws ServiceException {
        return null;
    }

    @Override
    public List<Task> getTasksByTeamId(int id) throws ServiceException {
        try {
            return taskDAO.getTasksByTeamId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
