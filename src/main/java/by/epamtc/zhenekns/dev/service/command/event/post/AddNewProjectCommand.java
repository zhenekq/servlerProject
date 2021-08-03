package by.epamtc.zhenekns.dev.service.command.event.post;

import by.epamtc.zhenekns.dev.dao.ProjectDAO;
import by.epamtc.zhenekns.dev.dao.implementation.ProjectDAOImpl;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPageRedirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewProjectCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String qualification = request.getParameter("qualification");
        int teamSize = Integer.parseInt(request.getParameter("teamSize"));
        int cost = Integer.parseInt(request.getParameter("cost"));
        String deadline = request.getParameter("deadline");
        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();
        System.out.println("ADD NEW PROJECT ADD NEW PROJECT ADD NEW PROJECT ADD NEW PROJECT ADD NEW PROJECT ");

        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setQualification(qualification);
        project.setTeamSize(teamSize);
        project.setCost(cost);
        project.setDeadline(deadline);
        project.setUser_id(userId);

        ProjectDAO projectDAO = new ProjectDAOImpl();
        projectDAO.addNewProject(project);
        System.out.println(title);
        System.out.println(description);
        System.out.println(qualification);
        System.out.println(teamSize);
        System.out.println(cost);
        System.out.println(deadline);
        System.out.println(userId);
        response.sendRedirect(request.getContextPath() + CommandPageRedirect.AUTHORIZED_MAIN_PAGE);

    }
}
