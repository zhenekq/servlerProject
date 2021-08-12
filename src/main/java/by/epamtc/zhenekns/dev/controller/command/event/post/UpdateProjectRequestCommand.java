package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
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

public class UpdateProjectRequestCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final ProjectResponseService projectResponseService = ServiceFactory.getInstance().getProjectResponseService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String date = request.getParameter("date");
        int cost = Integer.parseInt(request.getParameter("cost"));
        String details = request.getParameter("details");

        ProjectResponse projectResponse =
                (ProjectResponse) request.getSession().getAttribute("response");
        projectResponse.setDeadline(date);
        projectResponse.setPossiblePrice(cost);
        projectResponse.setProjectDetails(details);

        try {
            projectResponseService.updateProjectResponse(projectResponse);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.getSession().removeAttribute("response");
        response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }
}
