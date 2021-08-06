package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AuthorizedMainPage implements Command {

    private final static Logger logger = LogManager.getLogger();
    private final static UserService userService = ServiceFactory.getInstance().getUserService();
    private final static  ProjectService projectService = ServiceFactory.getInstance().getProjectService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        if (user.getRole().equals("MANAGER")) {
            Map<Project, User> projects = null;
            try {
                projects = projectService.getAllProjects();
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
                    e.printStackTrace();
                }
                manager.setUserInfo(userInfo);
            }
            request.setAttribute("managers", managers);
        }
        request.getRequestDispatcher(CommandPage.AUTHORIZED_MAIN_PAGE_JSP)
                .forward(request, response);
    }
}
