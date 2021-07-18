package by.epamtc.zhenekns.dev.service.command.event.post;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.SessionAttributes;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;
import by.epamtc.zhenekns.dev.service.user.UserService;
import by.epamtc.zhenekns.dev.service.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthorizationCommand implements Command {

    private static User user = User.getInstance();
    private static final UserService userService = new UserServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("THERE");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if (userService.getUserByEmailPassword(username, password) != null) {
            System.out.println("IDENT");
            session.setAttribute(SessionAttributes.SESSION_USERNAME, username);
            session.setAttribute(SessionAttributes.SESSION_ROLE, user.getRole());
            session.setAttribute(SessionAttributes.SESSION_PASSWORD, password);
            request.getRequestDispatcher(CommandPage.MAIN_PAGE_JSP).forward(request, response);
        } else {
            System.out.println("NO");
            request.getRequestDispatcher(CommandPage.AUTHORIZATION_PAGE_JSP).forward(request, response);
        }
    }
}
