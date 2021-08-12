package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProjectInfoCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final ProjectService projectService = ServiceFactory.getInstance().getProjectService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int projectId = Integer.parseInt(request.getParameter("id"));
        Project project = null;
        try {
            project = projectService.getProjectById(projectId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR,e.getMessage());
        }

        request.setAttribute("project", project);
        request.getRequestDispatcher(CommandPage.PROJECT_INFO_PAGE).forward(request,response);
    }
}
