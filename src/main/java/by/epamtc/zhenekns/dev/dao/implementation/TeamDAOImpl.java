package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.TeamDAO;
import by.epamtc.zhenekns.dev.dao.UserDAO;
import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAOImpl implements TeamDAO {


    @Override
    public Team createTeam(Team team) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO team values(?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1, team.getId());
            preparedStatement.setString(2, team.getName());
            preparedStatement.setString(3, team.getDescription());
            preparedStatement.setInt(4, team.getTeamSize());
            preparedStatement.setInt(5, team.getManagerId());
            preparedStatement.setString(6, team.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return team;
    }

    @Override
    public Team updateTeam(Team team) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE team  set name=?, description=?, teamSize=? where id=?"
            );
            preparedStatement.setString(1, team.getName());
            preparedStatement.setString(2, team.getDescription());
            preparedStatement.setInt(3, team.getTeamSize());
            preparedStatement.setInt(4, team.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return team;
    }

    @Override
    public Team deleteTeam(Team team) throws DaoException {
        return null;
    }

    @Override
    public Team getTeamByManagerId(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Team team = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM team where manager_id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("name"));
                team.setDescription(resultSet.getString("description"));
                team.setManagerId(resultSet.getInt("manager_id"));
                team.setTeamSize(resultSet.getInt("teamSize"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return team;
    }

    @Override
    public List<Team> getTeamsByManagerId(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        List<Team> teamList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM team where manager_id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Team team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("name"));
                team.setDescription(resultSet.getString("description"));
                team.setManagerId(resultSet.getInt("manager_id"));
                team.setTeamSize(resultSet.getInt("teamSize"));
                int currentTeamSize = getTeamSizeByTeamId(team.getId());
                team.setCurrentTeamSize(currentTeamSize);
                if (currentTeamSize != team.getTeamSize() || currentTeamSize == 0) {
                    teamList.add(team);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return teamList;
    }

    @Override
    public void addParticipantToTeam(int managerId, int devId, int teamId) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO team_dev VALUES (?,?,?,?)"
            );
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, managerId);
            preparedStatement.setInt(3, devId);
            preparedStatement.setInt(4, teamId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> getUsersByTeamId(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        List<User> userList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM team_dev where team_id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
            while (resultSet.next()) {
                int userId = resultSet.getInt("developer_id");
                User user = userDAO.getUserById(userId);
                UserInfo userInfo = userDAO.getAllInfoAboutUserById(userId);
                user.setUserInfo(userInfo);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userList;
    }

    @Override
    public int getTeamSizeByTeamId(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        int counter = 0;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM team_dev where team_id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                counter++;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return counter;
    }

    @Override
    public Team getTeamByDeveloperId(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Team team = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM team_dev where developer_id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                team = new Team();
                team.setId(resultSet.getInt("team_id"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return team;
    }

    @Override
    public Team getTeamById(int id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Team team = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM team where id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                team = new Team();
                int teamId = resultSet.getInt("id");
                team.setId(teamId);
                team.setName(resultSet.getString("name"));
                team.setDescription(resultSet.getString("description"));
                team.setManagerId(resultSet.getInt("manager_id"));
                team.setTeamSize(resultSet.getInt("teamSize"));
                team.setStatus(resultSet.getString("status"));
                team.setCurrentTeamSize(getTeamSizeByTeamId(teamId));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return team;
    }
}
