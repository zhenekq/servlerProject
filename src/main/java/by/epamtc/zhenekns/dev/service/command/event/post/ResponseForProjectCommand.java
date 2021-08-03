package by.epamtc.zhenekns.dev.service.command.event.post;

import by.epamtc.zhenekns.dev.dao.ProjectDAO;
import by.epamtc.zhenekns.dev.dao.implementation.ProjectDAOImpl;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.ProjectResponse;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.service.implementation.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseForProjectCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String date = request.getParameter("date");
        String details = request.getParameter("details");
        int cost = Integer.parseInt(request.getParameter("cost"));

        ProjectService projectService = new ProjectServiceImpl();
        Project project = (Project) request.getSession().getAttribute("project");

        int projectOwner = project.getUser_id();
        User user = (User) request.getSession().getAttribute("user");
        int responseId = user.getId();

        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setDeadline(date);
        projectResponse.setOwnerId(projectOwner);
        projectResponse.setResponsibleId(responseId);
        projectResponse.setProjectId(project.getId());
        projectResponse.setProjectDetails(details);
        projectResponse.setPossiblePrice(cost);
        ProjectDAO projectDAO = new ProjectDAOImpl();
        projectDAO.addResponseForProject(projectResponse);
        request.getSession().removeAttribute("project");
        response.sendRedirect(request.getContextPath() + CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }
}
