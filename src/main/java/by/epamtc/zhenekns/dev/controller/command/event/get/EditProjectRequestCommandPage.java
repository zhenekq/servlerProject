package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectResponseService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.util.RequestAttributes;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProjectRequestCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final ProjectResponseService projectResponseService = ServiceFactory.getInstance().getProjectResponseService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter(RequestAttributes.ID));
        ProjectResponse projectResponse = null;
        try {
            projectResponse = projectResponseService.getProjectResponseById(id);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.getSession().setAttribute(RequestAttributes.RESPONSE, projectResponse);
        request.getRequestDispatcher(CommandPage.EDIT_PROJECT_REQUEST_PAGE).forward(request, response);
    }
}
