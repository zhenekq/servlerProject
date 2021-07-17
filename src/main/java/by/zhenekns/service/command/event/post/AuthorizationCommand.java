package by.zhenekns.service.command.event.post;

import by.zhenekns.entity.Role;
import by.zhenekns.entity.User;
import by.zhenekns.service.command.Command;
import by.zhenekns.service.command.CommandPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthorizationCommand implements Command {

    private static User user = User.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("THERE");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        String role = Role.ADMIN.toString();
        String userRole = user.getRole();
        boolean isIdentRoles = userRole.equals(role);
        RequestDispatcher requestDispatcher;
        if (isIdentRoles) {
            System.out.println("IDENT");
            session.setAttribute("username", username);
            session.setAttribute("userRole", user.getRole());
            session.setAttribute("password", password);
            requestDispatcher = request.getRequestDispatcher(CommandPage.MAIN_PAGE_JSP);
            requestDispatcher.forward(request, response);
        } else {
            System.out.println("NO");
            requestDispatcher = request.getRequestDispatcher(CommandPage.AUTHORIZATION_PAGE_JSP);
            requestDispatcher.forward(request, response);
        }
    }
}
