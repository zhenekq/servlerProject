package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.ProjectResponseDAO;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public ProjectResponse getProjectResponseByResponderId(int id) throws DaoException {
        return null;
    }
}
