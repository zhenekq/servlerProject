package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TaskService;
import by.epamtc.zhenekns.dev.status.TaskStatus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewTaskCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TaskService taskService = ServiceFactory.getInstance().getTaskService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int teamId = Integer.parseInt(request.getParameter("team"));
        Task task = new Task();
        setTask(task, name, description, teamId, TaskStatus.NOT_COMPLETED);
        try {
            taskService.addTask(task);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }

    private void setTask(Task task, String name, String desc, int teamId, String status) {
        task.setName(name);
        task.setDescription(desc);
        task.setTeamId(teamId);
        task.setStatus(status);
    }
}


