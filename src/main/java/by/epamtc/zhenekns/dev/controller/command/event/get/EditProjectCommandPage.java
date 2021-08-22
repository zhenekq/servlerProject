package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.util.RequestAttributes;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProjectCommandPage implements Command {

    private static final ProjectService projectService = ServiceFactory.getInstance().getProjectService();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int projectId = Integer.parseInt(request.getParameter(RequestAttributes.ID));
        User user = (User) request.getSession().getAttribute(RequestAttributes.USER);
        Project project = null;
        try {
            int ownerId = projectService.getProjectById(projectId).getUser_id();
            if (ownerId == user.getId() || user.getRole().equals(Role.ADMIN.toString())) {
                project = projectService.getProjectById(projectId);
                request.setAttribute(RequestAttributes.PROJECT, project);
                request.getSession().setAttribute(RequestAttributes.EDIT_PROJECT, project);
                request.getRequestDispatcher(CommandPage.EDIT_PROJECT_PAGE).forward(request, response);
            } else {
                response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
            }
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
