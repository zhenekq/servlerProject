package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
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

public class AddNewTeamCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TeamService teamService = ServiceFactory.getInstance().getTeamService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");

        int managerId = user.getId();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int teamSize = Integer.parseInt(request.getParameter("teamSize"));

        Team team = new Team();
        setTeam(team, name, description, teamSize, managerId);

        try {
            teamService.createTeam(team);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(CommandPageRedirect.MANAGER_TEAMS);
    }

    private static void setTeam(Team team, String name, String description, int teamSize, int managerId) {
        team.setDescription(description);
        team.setName(name);
        team.setTeamSize(teamSize);
        team.setManagerId(managerId);
    }
}
