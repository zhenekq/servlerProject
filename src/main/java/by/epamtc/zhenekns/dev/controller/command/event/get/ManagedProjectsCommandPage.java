package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectResponseService;
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

public class ManagedProjectsCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final ProjectResponseService projectResponseService = ServiceFactory.getInstance().getProjectResponseService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute(RequestAttributes.USER);
        int managerId = user.getId();
        List<ProjectResponse> projectResponses = null;
        try {
            projectResponses = projectResponseService.getProjectResponsesByResponderIdAndStatus(ProjectResponseStatus.APPROVED, managerId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR,e.getMessage());
        }
        request.setAttribute(RequestAttributes.PROJECT_RESPONSES, projectResponses);
        request.getRequestDispatcher(CommandPage.MANAGED_PROJECTS_PAGE).forward(request,response);
    }
}
