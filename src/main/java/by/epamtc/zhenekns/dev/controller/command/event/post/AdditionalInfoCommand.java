package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdditionalInfoCommand implements Command {

    private final static Logger logger = LogManager.getLogger();
    private final static UserService userService = ServiceFactory.getInstance().getUserService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserInfo userInfo;
        User user = (User) request.getSession().getAttribute("user");
        int idUserInfo = 0;
        try {
            idUserInfo = userService.getLastIdInfo() + 1;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        String userCountry = request.getParameter("country");
        String userCity = request.getParameter("city");
        String userExperience = request.getParameter("experience");
        String userSocialLink = request.getParameter("social_link");
        String userDateOfBirth = request.getParameter("date");
        String aboutUser = request.getParameter("about");
        String status = "online";

        userInfo = new UserInfo(idUserInfo, status, aboutUser,
                userCountry, userCity, userExperience, userDateOfBirth,
                userSocialLink, user.getId());
        try {
            userService.addAdditionalInfo(userInfo);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
    }

}
