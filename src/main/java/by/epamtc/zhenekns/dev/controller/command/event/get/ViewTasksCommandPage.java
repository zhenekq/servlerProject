package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TaskService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewTasksCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TaskService taskService = ServiceFactory.getInstance().getTaskService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int teamId = Integer.parseInt(request.getParameter("id"));
        List<Task> tasks = null;
        try {
            tasks = taskService.getTasksByTeamId(teamId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher(CommandPage.VIEW_TASKS).forward(request,response);
    }
}
