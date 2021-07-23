package by.epamtc.zhenekns.dev.service.command.event.post;

import by.epamtc.zhenekns.dev.dao.user.UserDAO;
import by.epamtc.zhenekns.dev.dao.user.UserDAOImpl;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;
import by.epamtc.zhenekns.dev.service.user.UserService;
import by.epamtc.zhenekns.dev.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private static User user = User.getInstance();
    private static UserDAO userDAO = new UserDAOImpl();
    private static UserService userService = new UserServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("REGISTRATION");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleUser = request.getParameter("radio");
        UserDAOImpl userService1 = new UserDAOImpl();
        int userId = userService1.getLastId() + 1;
        if(roleUser == null){
            request.setAttribute("error_message", "Choose the role please!");
            request.getRequestDispatcher(CommandPage.REGISTRATION_PAGE_JSP).forward(request, response);
            return;
        }
        Role role = Role.valueOf(roleUser.toUpperCase());
        if (!userService.checkUser(username, email)) {
            user.setId(userId);
            user.setEmail(email);
            user.setNickname(username);
            user.setPassword(password);
            user.setRole(role);
            System.out.println(user);
            userDAO.addUser(user);
            request.getRequestDispatcher(CommandPage.MAIN_PAGE_JSP).forward(request, response);
        } else if(userService.checkUser(username, email)){
            request.setAttribute("error_message", "User exists, try to login please!");
            request.getRequestDispatcher(CommandPage.REGISTRATION_PAGE_JSP).forward(request, response);
        }else{
            request.setAttribute("error_message", "Fill all fields please!");
            request.getRequestDispatcher(CommandPage.REGISTRATION_PAGE_JSP).forward(request, response);
        }
    }
}
