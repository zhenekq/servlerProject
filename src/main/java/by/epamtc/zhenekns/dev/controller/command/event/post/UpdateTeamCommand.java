package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.Team;
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

public class UpdateTeamCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private TeamService teamService = ServiceFactory.getInstance().getTeamService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        int teamSize = Integer.parseInt(request.getParameter("teamSize"));
        Team team = (Team) request.getSession().getAttribute("team");
        setTeam(team, name, desc, teamSize);
        try {
            teamService.updateTeam(team);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.getSession().removeAttribute("team");
        response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }

    private void setTeam(Team team, String name, String desc, int teamSize) {
        team.setName(name);
        team.setDescription(desc);
        team.setTeamSize(teamSize);
    }
}
