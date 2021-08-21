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
    List<User> getUsersByTeamId(int id) throws DaoException;
    int getTeamSizeByTeamId(int id) throws DaoException;
    Team getTeamByDeveloperId(int id) throws DaoException;
    Team getTeamById(int id) throws DaoException;

    void deleteTeammate(int teammateId) throws DaoException;
    List<Team> getAllTeams() throws DaoException;
    void updateTeamStatusById(int teamId, String status) throws DaoException;
    List<Team> getTeamsByStatus(String status) throws DaoException;
}