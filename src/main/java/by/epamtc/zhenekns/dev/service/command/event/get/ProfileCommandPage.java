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

public class ProfileCommandPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserService userService = new UserServiceImpl();
        User sessionUser = (User) request.getSession().getAttribute("user");
        User user = userService.getUserById(sessionUser.getId());
        request.setAttribute("user", user);
        UserInfo userInfo = userService.getAllInfoAboutUserById(sessionUser.getId());
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher(CommandPage.PROFILE_JSP).forward(request, response);
    }
}
