package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProjectCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private static final ProjectService projectService = ServiceFactory.getInstance().getProjectService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Project project = (Project) request.getSession().getAttribute("editProject");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String qualification = request.getParameter("qualification");
        int teamSize = Integer.parseInt(request.getParameter("teamSize"));
        String deadline = request.getParameter("deadline");
        int cost = Integer.parseInt(request.getParameter("cost"));


        setProjectDetails(project, title, description, qualification, teamSize, deadline, cost);
        try {
            projectService.updateProjectDetails(project);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }

    private static void setProjectDetails(Project project, String title, String description,
                                          String qualification, int teamSize, String deadline,
                                          int cost) {
        project.setTitle(title);
        project.setDescription(description);
        project.setQualification(qualification);
        project.setTeamSize(teamSize);
        project.setDeadline(deadline);
        project.setCost(cost);

    }
}
