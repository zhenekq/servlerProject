package by.epamtc.zhenekns.dev.controller.command.event.post;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProfileCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = null;
        try {
            userInfo = userService.getAllInfoAboutUserById(user.getId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String experience = request.getParameter("experience");
        String socialLink = request.getParameter("social_link");
        String date = request.getParameter("date");
        String about = request.getParameter("about");

        assert userInfo != null;
        setUserInfo(userInfo, country, city, experience, socialLink, date, about);
        user.setUserInfo(userInfo);
        try {
            userService.updateUser(user);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "?command=authorized_main_page");
    }

    private static void setUserInfo(UserInfo userInfo, String country, String city,
                                    String experience, String link, String date,
                                    String about) {
        userInfo.setCountry(country);
        userInfo.setCity(city);
        userInfo.setExperience(experience);
        userInfo.setSocialLink(link);
        userInfo.setDateOfRegistration(date);
        userInfo.setQualification(about);

    }
}
