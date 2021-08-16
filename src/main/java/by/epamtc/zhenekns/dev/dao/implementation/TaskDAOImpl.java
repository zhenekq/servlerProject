package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.TaskDAO;
import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Override
    public Task addTask(Task task) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO task VALUES(?,?,?,?,?)"
            );
            preparedStatement.setInt(1, task.getId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setInt(4, task.getTeamId());
            preparedStatement.setString(5, task.getStatus());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException(e);
        }
        return task;
    }

    @Override
    public Task updateTask(Task task) throws DaoException {
        return null;
    }

    @Override
    public Task deleteTask(Task task) throws DaoException {
        return null;
    }

    @Override
    public List<Task> getTasksByManagerId(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Task> getTasksByDeveloperId(int id) throws DaoException {
        return null;
    }

    @Override
    public Task getTaskById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Task> getTasksByTeamId(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        List<Task> tasks = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM task where team_id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setTeamId(resultSet.getInt("team_id"));
                task.setStatus(resultSet.getString("status"));
                tasks.add(task);
            }
        }catch (SQLException e){
            throw new DaoException(e);
        }
        return tasks;
    }
}
