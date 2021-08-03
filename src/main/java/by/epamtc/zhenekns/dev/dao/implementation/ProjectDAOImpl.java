package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.ProjectDAO;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public void addResponseForProject(ProjectResponse projectResponse) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders_resp VALUES (?,?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1, projectResponse.getId());
            preparedStatement.setInt(2, projectResponse.getOwnerId());
            preparedStatement.setInt(3, projectResponse.getResponsibleId());
            preparedStatement.setInt(4, projectResponse.getProjectId());
            preparedStatement.setString(5, projectResponse.getProjectDetails());
            preparedStatement.setInt(6,projectResponse.getPossiblePrice());
            preparedStatement.setString(7, projectResponse.getDeadline());
            System.out.println(projectResponse.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
