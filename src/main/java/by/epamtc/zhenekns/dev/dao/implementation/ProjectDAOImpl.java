package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.ProjectDAO;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProjectDAOImpl implements ProjectDAO {

    @Override
    public Project addNewProject(Project project) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2,project.getTitle());
            preparedStatement.setString(3,project.getDescription());
            preparedStatement.setString(4,project.getQualification());
            preparedStatement.setInt(5,project.getTeamSize());
            preparedStatement.setInt(6,project.getCost());
            preparedStatement.setString(7,project.getDeadline());
            preparedStatement.setInt(8,project.getUser_id());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return project;
    }

    @Override
    public Project deleteProject(Project project) {
        return null;
    }

    @Override
    public Project updateProject(Project project) {
        return null;
    }

    @Override
    public Map<Project, User> getAllProjects() throws DaoException {
        Map<Project, User> projects = new LinkedHashMap<>();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()){
            //connection = connectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders order by id desc");
            while (resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDescription(resultSet.getString("description"));
                project.setQualification(resultSet.getString("qualification"));
                project.setTeamSize(resultSet.getInt("team_size"));
                project.setCost(resultSet.getInt("cost"));
                project.setDeadline(resultSet.getString("deadline"));
                project.setUser_id(resultSet.getInt("user_id"));
                UserService userService = new UserServiceImpl();
                int id = project.getUser_id();
                User user = userService.getUserById(id);
                projects.put(project, user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public List<Project> getProjectsByUserId(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        List<Project> projects = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM orders where user_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDescription(resultSet.getString("description"));
                project.setQualification(resultSet.getString("qualification"));
                project.setTeamSize(resultSet.getInt("team_size"));
                project.setCost(resultSet.getInt("cost"));
                project.setDeadline(resultSet.getString("deadline"));
                project.setUser_id(resultSet.getInt("user_id"));

                projects.add(project);
            }
        }catch (SQLException e){
            throw new DaoException(e);
        }
        return projects;
    }

    @Override
    public Project getProjectById(int id) throws DaoException {
        Project project = new Project();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM orders where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDescription(resultSet.getString("description"));
                project.setQualification(resultSet.getString("qualification"));
                project.setTeamSize(resultSet.getInt("team_size"));
                project.setCost(resultSet.getInt("cost"));
                project.setDeadline(resultSet.getString("deadline"));
                project.setUser_id(resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }
}
