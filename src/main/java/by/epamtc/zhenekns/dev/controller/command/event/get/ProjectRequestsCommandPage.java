package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectResponseService;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.status.ProjectResponseStatus;
import by.epamtc.zhenekns.dev.util.RequestAttributes;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProjectRequestsCommandPage implements Command {

    private static final Logger logger = LogManager.getLogger();
    private static final ProjectResponseService projectResponseService =
            ServiceFactory.getInstance().getProjectResponseService();
    private static final ProjectService projectService = ServiceFactory.getInstance().getProjectService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute(RequestAttributes.USER);
        int userId = user.getId();
        List<ProjectResponse> projectResponses = null;
        List<Project> project = null;
        try {
            projectResponses = projectResponseService.getProjectResponsesByResponderIdAndAvoidStatus(ProjectResponseStatus.APPROVED, userId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.setAttribute(RequestAttributes.PROJECT_RESPONSES, projectResponses);
        request.getRequestDispatcher(CommandPage.PROJECT_REQUEST).forward(request, response);
    }
}
