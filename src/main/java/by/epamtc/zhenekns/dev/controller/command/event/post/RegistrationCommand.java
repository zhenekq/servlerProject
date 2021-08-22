package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static UserService userService = serviceFactory.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserInfo userInfo = new UserInfo();
        User user = null;
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleUser = request.getParameter("radio");

        int userId = 0;
        try {
            userId = userService.getLastId() + 1;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (roleUser == null) {
            request.setAttribute("error_message", "Choose the role please!");
            request.getRequestDispatcher(CommandPage.REGISTRATION_PAGE_JSP).forward(request, response);
            return;
        }
        Role role = Role.valueOf(roleUser.toUpperCase());
        try {
            if (!userService.checkUser(username, email)) {
                user = new User(userId, email, password, username, role);
                userService.authorizationUser(user);
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + CommandPageRedirect.ADDITIONAL_INFO_PAGE);
            } else {
                request.setAttribute("error_message", "Data is incorrect!");
                request.getRequestDispatcher(CommandPage.REGISTRATION_PAGE_JSP).forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
