package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthorizationCommand implements Command {

    private static final UserService userService = new UserServiceImpl();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            if (userService.loginUser(email, password) != null) {
                User user = userService.loginUser(email, password);
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "?command=authorized_main_page");
            } else {
                request.setAttribute("error_message_login", "User not found, check your input data please!");
                request.getRequestDispatcher(CommandPage.AUTHORIZATION_PAGE_JSP).forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
