package by.epamtc.zhenekns.dev.service.command.event.get;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdditionalInfoCommandPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = User.getInstance();
        UserInfo userInfo = UserInfo.getInstance();
        System.out.println(user.getId());
        System.out.println(userInfo.getUserId());
        request.setAttribute("username", User.getInstance().getNickname());
        request.setAttribute("userEmail", User.getInstance().getEmail());
        System.out.println(User.getInstance().getNickname());
        System.out.println(User.getInstance().getEmail());
        request.setAttribute("user", user);
        request.getRequestDispatcher(CommandPage.ADDITIONAL_PAGE_JPS).forward(request,response);
    }
}
