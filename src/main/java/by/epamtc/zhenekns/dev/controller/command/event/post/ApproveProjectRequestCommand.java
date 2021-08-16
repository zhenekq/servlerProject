package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectResponseService;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.status.ProjectResponseStatus;
import by.epamtc.zhenekns.dev.status.ProjectStatus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApproveProjectRequestCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private static final ProjectResponseService projectResponseService = ServiceFactory.getInstance().getProjectResponseService();
    private static final ProjectService projectService = ServiceFactory.getInstance().getProjectService();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            ProjectResponse projectResponse = projectResponseService.getProjectResponseById(id);
            int projectId = projectResponse.getProjectId();
            System.out.println(projectId);
            projectResponseService.updateProjectResponseStatusById(ProjectResponseStatus.APPROVED, id);
            projectService.updateProjectStatusById(ProjectStatus.CLOSED_FOR_REQUESTS, projectId);


        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }
}
