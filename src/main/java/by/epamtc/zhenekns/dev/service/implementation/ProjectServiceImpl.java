package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.service.ProjectService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try {
            Connection connection = connectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
            Project project = new Project();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getProjectById(int id) {
        return null;
    }
}
