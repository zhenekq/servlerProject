package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TeamService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShowManagerTeamsCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TeamService teamService = ServiceFactory.getInstance().getTeamService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        int managerId = user.getId();
        List<Team> teams = null;
        try {
            teams = teamService.getTeamsByManagerId(managerId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        Map<Team, List<User>> teamListMap = new LinkedHashMap<>();
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            List<User> userList = null;
            try {
                userList = teamService.getUsersByTeamId(team.getId());
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            teamListMap.put(team, userList);
        }
        request.setAttribute("teams", teamListMap);
        request.getRequestDispatcher(CommandPage.MANAGER_TEAMS_PAGE).forward(request, response);
    }
}
