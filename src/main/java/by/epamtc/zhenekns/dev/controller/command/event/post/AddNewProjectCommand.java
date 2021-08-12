package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.status.ProjectStatus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewProjectCommand implements Command {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProjectService projectService = ServiceFactory.getInstance().getProjectService();

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String qualification = request.getParameter("qualification");
        //try
        int teamSize = Integer.parseInt(request.getParameter("teamSize"));
        int cost = Integer.parseInt(request.getParameter("cost"));
        String deadline = request.getParameter("deadline");

        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();

        Project project = new Project(title, description, qualification,
                                      teamSize, cost, deadline, userId);
        project.setStatus(ProjectStatus.OPEN_FOR_REQUESTS);
        try {
            projectService.addNewProject(project);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + CommandPageRedirect.AUTHORIZED_MAIN_PAGE);

    }
}
