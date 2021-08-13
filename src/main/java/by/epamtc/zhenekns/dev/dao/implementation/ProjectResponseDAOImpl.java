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

public class ProjectResponseDAOImpl implements ProjectResponseDAO {

    @Override
    public ProjectResponse addProjectResponse(ProjectResponse projectResponse) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders_resp VALUES (?,?,?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1, projectResponse.getId());
            preparedStatement.setInt(2, projectResponse.getOwnerId());
            preparedStatement.setInt(3, projectResponse.getResponsibleId());
            preparedStatement.setInt(4, projectResponse.getProjectId());
            preparedStatement.setString(5, projectResponse.getProjectDetails());
            preparedStatement.setInt(6, projectResponse.getPossiblePrice());
            preparedStatement.setString(7, projectResponse.getDeadline());
            preparedStatement.setString(8, projectResponse.getStatus());
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
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE orders_resp set details=?, price=?,deadline=?" +
                            "where id=?"
            );
            preparedStatement.setString(1, projectResponse.getProjectDetails());
            preparedStatement.setInt(2,projectResponse.getPossiblePrice());
            preparedStatement.setString(3,projectResponse.getDeadline());
            preparedStatement.setInt(4, projectResponse.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return projectResponse;
    }

    @Override
    public List<ProjectResponse> getProjectResponsesByResponderId(int id) throws DaoException {
        List<ProjectResponse> projectResponses = new ArrayList<>();

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM orders_resp where responcer_id = ? order by id desc");
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
                projectResponse.setStatus(resultSet.getString("status"));
                projectResponses.add(projectResponse);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return projectResponses;
    }

    @Override
    public ProjectResponse getProjectResponseById(int id) throws DaoException {
        ProjectResponse projectResponse = new ProjectResponse();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM orders_resp where id=?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                projectResponse.setId(resultSet.getInt("id"));
                projectResponse.setOwnerId(resultSet.getInt("owner_id"));
                projectResponse.setResponsibleId(resultSet.getInt("responcer_id"));
                projectResponse.setProjectId(resultSet.getInt("project_id"));
                projectResponse.setProjectDetails(resultSet.getString("details"));
                projectResponse.setPossiblePrice(resultSet.getInt("price"));
                projectResponse.setDeadline(resultSet.getString("deadline"));
                projectResponse.setStatus(resultSet.getString("status"));
            }
        }catch (SQLException e){
            throw new DaoException(e);
        }
        return projectResponse;
    }

    @Override
    public List<ProjectResponse> getProjectResponsesByOwnerId(int id) throws DaoException {
        List<ProjectResponse> projectResponses = new ArrayList<>();

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM orders_resp where owner_id = ? order by id desc");
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
                projectResponse.setStatus(resultSet.getString("status"));
                projectResponses.add(projectResponse);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return projectResponses;
    }

    @Override
    public void updateProjectResponseStatusById(String status, int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE orders_resp set status = ? where id = ?"
            );
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException(e);
        }
    }

    @Override
    public List<ProjectResponse> getProjectResponsesByResponderIdAndAvoidStatus(String status, int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        List<ProjectResponse> projectResponses = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM orders_resp where responcer_id = ? and status != ? order by id desc"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProjectResponse projectResponse = new ProjectResponse();
                projectResponse.setId(resultSet.getInt("id"));
                projectResponse.setOwnerId(resultSet.getInt("owner_id"));
                projectResponse.setResponsibleId(resultSet.getInt("responcer_id"));
                projectResponse.setProjectId(resultSet.getInt("project_id"));
                projectResponse.setProjectDetails(resultSet.getString("details"));
                projectResponse.setPossiblePrice(resultSet.getInt("price"));
                projectResponse.setDeadline(resultSet.getString("deadline"));
                projectResponse.setStatus(resultSet.getString("status"));
                projectResponses.add(projectResponse);
            }
        }catch (SQLException e){
            throw new DaoException(e);
        }
        return projectResponses;
    }

    @Override
    public List<ProjectResponse> getProjectResponsesByResponderIdAndStatus(String status, int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        List<ProjectResponse> projectResponses = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM orders_resp where responcer_id = ? and status = ? order by id desc"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProjectResponse projectResponse = new ProjectResponse();
                projectResponse.setId(resultSet.getInt("id"));
                projectResponse.setOwnerId(resultSet.getInt("owner_id"));
                projectResponse.setResponsibleId(resultSet.getInt("responcer_id"));
                projectResponse.setProjectId(resultSet.getInt("project_id"));
                projectResponse.setProjectDetails(resultSet.getString("details"));
                projectResponse.setPossiblePrice(resultSet.getInt("price"));
                projectResponse.setDeadline(resultSet.getString("deadline"));
                projectResponse.setStatus(resultSet.getString("status"));
                projectResponses.add(projectResponse);
            }
        }catch (SQLException e){
            throw new DaoException(e);
        }
        return projectResponses;
    }
}
