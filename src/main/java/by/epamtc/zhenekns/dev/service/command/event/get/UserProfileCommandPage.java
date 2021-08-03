package by.epamtc.zhenekns.dev.service.command.event.get;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserProfileCommandPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserServiceImpl();
        UserInfo userInfo = userService.getAllInfoAboutUserById(userId);
        User user = userService.getUserById(userId);
        System.out.println("There");
        request.setAttribute("user", user);
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher(CommandPage.USER_PROFILE_JSP).forward(request,response);
    }
}
