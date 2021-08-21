package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TaskService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class DeleteTaskCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TaskService taskService = ServiceFactory.getInstance().getTaskService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        try {
            taskService.deleteTaskById(taskId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }
}
