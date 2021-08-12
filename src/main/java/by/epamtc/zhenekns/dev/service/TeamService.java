package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.exception.ServiceException;

import java.util.List;

public interface TeamService {

    Team createTeam(Team team) throws ServiceException;

    List<Team> getTeamsByManagerId(int id) throws ServiceException;

}
