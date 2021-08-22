package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.util.RequestAttributes;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileCommandPage implements Command {
    private final static Logger logger = LogManager.getLogger();
    private final static UserService userService = ServiceFactory.getInstance().getUserService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute(RequestAttributes.USER);
        UserInfo userInfo = null;
        try {
            userInfo = userService.getAllInfoAboutUserById(user.getId());
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        request.setAttribute(RequestAttributes.USER, user);
        request.setAttribute(RequestAttributes.USER_INFO, userInfo);
        request.getRequestDispatcher(CommandPage.PROFILE_JSP).forward(request, response);
    }
}
