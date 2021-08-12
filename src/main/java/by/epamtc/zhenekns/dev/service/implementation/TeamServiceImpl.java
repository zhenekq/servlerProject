package by.epamtc.zhenekns.dev.service.implementation;

import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.TeamDAO;
import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.TeamService;

import java.util.List;

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
}
