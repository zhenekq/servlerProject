package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.ProjectResponseDAO;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectResponseImpl implements ProjectResponseDAO {

    @Override
    public ProjectResponse addProjectResponse(ProjectResponse projectResponse) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders_resp VALUES (?,?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1, projectResponse.getId());
            preparedStatement.setInt(2, projectResponse.getOwnerId());
            preparedStatement.setInt(3, projectResponse.getResponsibleId());
            preparedStatement.setInt(4, projectResponse.getProjectId());
            preparedStatement.setString(5, projectResponse.getProjectDetails());
            preparedStatement.setInt(6, projectResponse.getPossiblePrice());
            preparedStatement.setString(7, projectResponse.getDeadline());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return projectResponse;
    }

    @Override
    public ProjectResponse cancelProjectResponse(ProjectResponse projectResponse) throws DaoException {
        return null;
    }

    @Override
    public ProjectResponse updateProjectResponse(ProjectResponse projectResponse) throws DaoException {
        return null;
    }

    @Override
    public List<ProjectResponse> getProjectResponsesByResponderId(int id) throws DaoException {
        List<ProjectResponse> projectResponses = new ArrayList<>();

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM orders_resp where responcer_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProjectResponse projectResponse = new ProjectResponse();
                projectResponse.setId(resultSet.getInt("id"));
                projectResponse.setOwnerId(resultSet.getInt("owner_id"));
                projectResponse.setResponsibleId(resultSet.getInt("responcer_id"));
                projectResponse.setProjectId(resultSet.getInt("project_id"));
                projectResponse.setProjectDetails(resultSet.getString("details"));
                projectResponse.setPossiblePrice(resultSet.getInt("price"));
                projectResponse.setDeadline(resultSet.getString("deadline"));

                projectResponses.add(projectResponse);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return projectResponses;
    }
}
