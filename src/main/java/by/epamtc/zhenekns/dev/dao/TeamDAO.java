package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface TeamDAO {

    Team createTeam(Team team) throws DaoException;
    Team updateTeam(Team team) throws DaoException;
    Team deleteTeam(Team team) throws DaoException;
    Team getTeamByManagerId(int id) throws DaoException;
    List<Team> getTeamsByManagerId(int id) throws DaoException;
    void addParticipantToTeam(int managerId, int devId, int teamId) throws DaoException;


}
