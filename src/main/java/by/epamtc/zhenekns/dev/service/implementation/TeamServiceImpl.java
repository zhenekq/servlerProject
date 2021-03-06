package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.TeamDAO;
import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.TeamService;

import java.util.List;
import java.util.Map;

public class TeamServiceImpl implements TeamService {

    private static final DAOFactory factory = DAOFactory.getInstance();
    private static final TeamDAO teamDAO = factory.getTeamDAO();

    @Override
    public Team createTeam(Team team) throws ServiceException {
        try {
            return teamDAO.createTeam(team);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Team> getTeamsByManagerId(int id) throws ServiceException {
        try {
            return teamDAO.getTeamsByManagerId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addParticipantToTeam(int managerId, int devId, int teamId) throws ServiceException {
        try {
            teamDAO.addParticipantToTeam(managerId, devId, teamId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsersByTeamId(int id) throws ServiceException {
        try {
            return teamDAO.getUsersByTeamId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Team getTeamByDeveloperId(int id) throws ServiceException {
        try {
            return teamDAO.getTeamByDeveloperId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getTeamSizeByTeamId(int id) throws ServiceException {
        try {
            return teamDAO.getTeamSizeByTeamId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Team getTeamById(int id) throws ServiceException {
        try {
            return teamDAO.getTeamById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Team updateTeam(Team team) throws ServiceException {
        try {
            return teamDAO.updateTeam(team);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteTeammate(int teammateId) throws ServiceException {
        try {
            teamDAO.deleteTeammate(teammateId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Team> getTeamsByStatus(String status) throws ServiceException {
        try {
            return teamDAO.getTeamsByStatus(status);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
