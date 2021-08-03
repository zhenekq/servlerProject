package by.epamtc.zhenekns.dev.service.command.event.get;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;
import by.epamtc.zhenekns.dev.service.implementation.ProjectServiceImpl;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AuthorizedMainPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        ProjectService projectDAO = new ProjectServiceImpl();
        Map<Project, User> projects = projectDAO.getAllProjects();
        request.setAttribute("projects", projects);
        request.setAttribute("user", user);
        if (user.getRole().equals("MANAGER")) {

        } else if (user.getRole().equals("CUSTOMER")) {
            UserService userService = new UserServiceImpl();
            List<User> managers = userService.getAllUserByRole(Role.valueOf(user.getRole()));
            for (User manager : managers) {
                UserInfo userInfo = userService.getAllInfoAboutUserById(manager.getId());
                manager.setUserInfo(userInfo);
            }
            request.setAttribute("managers", managers);
        }
        //System.out.println(projects);
        request.getRequestDispatcher(CommandPage.AUTHORIZED_MAIN_PAGE_JSP)
                .forward(request, response);
    }
}
