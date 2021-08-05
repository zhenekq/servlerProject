package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectResponseService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseForProjectCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private static final ProjectResponseService projectResponseService = ServiceFactory.getInstance().getProjectResponseService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        Project project = (Project) request.getSession().getAttribute("project");

        String date = request.getParameter("date");
        String details = request.getParameter("details");
        int cost = Integer.parseInt(request.getParameter("cost"));

        int projectOwnerId = project.getUser_id();
        int responseId = user.getId();
        int projectId = project.getId();

        ProjectResponse projectResponse = new ProjectResponse(projectOwnerId, responseId,
                                                              projectId, details,
                                                              cost, date);
        try {
            projectResponseService.addProjectResponse(projectResponse);
        } catch (ServiceException e) {
            logger.log(Level.ERROR,e.getMessage());
        }
        request.getSession().removeAttribute("project");
        response.sendRedirect(request.getContextPath() + CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }
}
