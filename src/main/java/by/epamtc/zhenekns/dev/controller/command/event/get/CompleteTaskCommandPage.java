package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TaskService;
import by.epamtc.zhenekns.dev.util.RequestAttributes;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompleteTaskCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TaskService taskService = ServiceFactory.getInstance().getTaskService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int taskId = Integer.parseInt(request.getParameter(RequestAttributes.ID));
        Task task = null;
        try {
            task = taskService.getTaskById(taskId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.getSession().setAttribute(RequestAttributes.TASK, task);
        request.getRequestDispatcher(CommandPage.COMPLETE_TASK_PAGE).forward(request, response);
    }
}
