package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface TeamService {

    Team createTeam(Team team) throws ServiceException;
    List<Team> getTeamsByManagerId(int id) throws ServiceException;
    void addParticipantToTeam(int managerId, int devId, int teamId) throws ServiceException;
    List<User> getUsersByTeamId(int id) throws ServiceException;
    Team getTeamByDeveloperId(int id) throws ServiceException;
    int getTeamSizeByTeamId(int id) throws ServiceException;
    Team getTeamById(int id) throws ServiceException;
    Team updateTeam(Team team) throws ServiceException;
    void deleteTeammate(int teammateId) throws ServiceException;
}
