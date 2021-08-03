package by.epamtc.zhenekns.dev.service.command.event.get;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;
import by.epamtc.zhenekns.dev.service.implementation.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowProjectCommandPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int projectId = Integer.parseInt(request.getParameter("id"));
        ProjectService projectService = new ProjectServiceImpl();
        Project project = projectService.getProjectById(projectId);
        request.setAttribute("project", project);
        request.getSession().setAttribute("project", project);
        request.getRequestDispatcher(CommandPage.SHOW_PROJECT_JSP).forward(request,response);
    }
}
