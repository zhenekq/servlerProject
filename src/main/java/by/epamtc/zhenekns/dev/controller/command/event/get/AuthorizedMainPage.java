package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.*;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TeamService;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.status.ProjectStatus;
import by.epamtc.zhenekns.dev.status.TeamStatus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AuthorizedMainPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final ProjectService projectService = ServiceFactory.getInstance().getProjectService();
    private final TeamService teamService = ServiceFactory.getInstance().getTeamService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");

        request.setAttribute("user", user);
        if (user.getRole().equals("MANAGER")) {
            Map<Project, User> projects = null;
            try {
                projects = projectService.getAllProjectsByStatus(ProjectStatus.OPEN_FOR_REQUESTS);
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            request.setAttribute("projects", projects);
        } else if (user.getRole().equals("CUSTOMER")) {
            List<User> managers = null;
            try {
                managers = userService.getAllUsersByRole(Role.MANAGER);
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            for (User manager : managers) {
                UserInfo userInfo = null;
                try {
                    userInfo = userService.getAllInfoAboutUserById(manager.getId());
                } catch (ServiceException e) {
                    logger.log(Level.ERROR, e.getMessage());
                }
                manager.setUserInfo(userInfo);
            }
            request.setAttribute("managers", managers);
        } else if (user.getRole().equals("ADMIN")) {
            List<User> users = null;
            if (request.getParameter("tag") == null || request.getParameter("tag").isEmpty()) {
                try {
                    users = userService.getAllUsers();
                } catch (ServiceException e) {
                    logger.log(Level.ERROR, e.getMessage());
                }
            } else {
                String tag = request.getParameter("tag");
                try {
                    users = userService.getUsersByTag(tag);
                } catch (ServiceException e) {
                    logger.log(Level.ERROR, e.getMessage());
                }
            }
            request.setAttribute("users", users);
        } else if (user.getRole().equals("DEVELOPER")) {
            List<Team> teams = null;
            try {
                teams = teamService.getTeamsByStatus(TeamStatus.HIRING);

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
        }
        request.getRequestDispatcher(CommandPage.AUTHORIZED_MAIN_PAGE_JSP)
                .forward(request, response);
    }
}
