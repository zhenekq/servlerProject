package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.entity.Team;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.TaskService;
import by.epamtc.zhenekns.dev.service.TeamService;
import by.epamtc.zhenekns.dev.status.TeamStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditTaskCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final TaskService taskService = ServiceFactory.getInstance().getTaskService();
    private final TeamService teamService = ServiceFactory.getInstance().getTeamService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        List<Team> teams = null;
        Task task = null;
        try {
            task = taskService.getTaskById(taskId);
            teams = teamService.getTeamsByManagerId(userId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.getSession().setAttribute("task", task);
        request.setAttribute("task", task);
        request.setAttribute("teams", teams);
        request.getRequestDispatcher(CommandPage.EDIT_TASK).forward(request,response);
    }
}
