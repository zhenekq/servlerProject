package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TeamService;
import by.epamtc.zhenekns.dev.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddToTeamCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TeamService teamService = ServiceFactory.getInstance().getTeamService();
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        User developer = null;
        int userIdDeveloper = Integer.parseInt(request.getParameter("id"));
        int userId = user.getId();
        List<Team> teams = null;
        try {
            teams = teamService.getTeamsByManagerId(userId);
            developer = userService.getUserById(userIdDeveloper);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.getSession().setAttribute("developer", developer);
        request.setAttribute("teams", teams);
        request.getRequestDispatcher(CommandPage.ADD_TO_TEAM_PAGE).forward(request, response);
    }
}
