package by.epamtc.zhenekns.dev.dao.implementation;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.TeamDAO;
import by.epamtc.zhenekns.dev.entity.Team;
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
                    "INSERT INTO team values(?,?,?,?,?)"
            );
            preparedStatement.setInt(1, team.getId());
            preparedStatement.setString(2, team.getName());
            preparedStatement.setString(3, team.getDescription());
            preparedStatement.setInt(4, team.getTeamSize());
            preparedStatement.setInt(5, team.getManagerId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return team;
    }

    @Override
    public Team updateTeam(Team team) throws DaoException {
        return null;
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
                teamList.add(team);
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
}
