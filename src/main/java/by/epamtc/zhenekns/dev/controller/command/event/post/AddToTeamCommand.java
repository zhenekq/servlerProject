package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TeamService;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.status.UserStatus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToTeamCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TeamService teamService = ServiceFactory.getInstance().getTeamService();
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User developer = (User) request.getSession().getAttribute("developer");
        User user = (User) request.getSession().getAttribute("user");
        int teamId = Integer.parseInt(request.getParameter("team"));
        int developerId = developer.getId();
        int managerId = user.getId();
        try {
            teamService.addParticipantToTeam(managerId, developerId, teamId);
            userService.updateUserStatusById(developerId, UserStatus.USER_ON_PROJECT);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.getSession().removeAttribute("developer");
        response.sendRedirect(CommandPageRedirect.FIND_DEVELOPER);
    }
}
