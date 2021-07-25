package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.ProjectDAO;
import by.epamtc.zhenekns.dev.entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDAOImpl implements ProjectDAO {

    @Override
    public Project addNewProject(Project project) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("");
            return new Project();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Project();
    }

    @Override
    public Project deleteProject(Project project) {
        return null;
    }

    @Override
    public Project updateProject(Project project) {
        return null;
    }
}
