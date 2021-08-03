package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.UserService;

import java.sql.*;
import java.util.*;

public class ProjectServiceImpl implements ProjectService {
    @Override
    public Map<Project, User> getAllProjects() {
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
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Project getProjectById(int id) {
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

    @Override
    public List<Project> getProjectsByUserId(int id) {
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
            e.printStackTrace();
        }
        return projects;
    }
}
