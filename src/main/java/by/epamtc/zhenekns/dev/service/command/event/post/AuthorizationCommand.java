package by.epamtc.zhenekns.dev.service.command.event.post;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class AuthorizationCommand implements Command {

    private static final UserService userService = new UserServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if (userService.getUserByEmailPassword(email, password) != null) {
            user = userService.getUserByEmailPassword(email,password);
            System.out.println(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "?command=authorized_main_page");
        } else {
            request.setAttribute("error_message_login", "User not found, check your input data please!");
            request.getRequestDispatcher(CommandPage.AUTHORIZATION_PAGE_JSP).forward(request, response);
        }
    }
}
