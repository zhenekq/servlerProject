package by.epamtc.zhenekns.dev.service.command.event.post;

import by.epamtc.zhenekns.dev.dao.UserDAO;
import by.epamtc.zhenekns.dev.dao.implementation.UserDAOImpl;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPageRedirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AdditionalInfoCommand implements Command {

    private final static Logger LOGGER =
            Logger.getLogger(AdditionalInfoCommand.class.getCanonicalName());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("ADDITIONAL INFO");
        UserInfo userInfo = UserInfo.getInstance();
        UserDAOImpl userDAO1 = new UserDAOImpl();
        User user = User.getInstance();
        UserDAO userDAO = new UserDAOImpl();
        int idUserInfo = userDAO1.getLastIdInfo() + 1;
        String userCountry = request.getParameter("country");
        String userCity = request.getParameter("city");
        String userExperience = request.getParameter("experience");
        String userSocialLink = request.getParameter("social_link");
        String userDateOfBirth = request.getParameter("date");
        String aboutUser = request.getParameter("about");

        System.out.println("Country: " + userCountry);
        System.out.println("City: " + userCity);
        System.out.println("Experience: " + userExperience);
        System.out.println("Social link: " + userSocialLink);
        System.out.println("Date of birth: " + userDateOfBirth);
        System.out.println("About user: " + aboutUser);

        userInfo.setId(idUserInfo);
        userInfo.setQualification(aboutUser);
        userInfo.setStatus("online");
        userInfo.setExperience(userExperience);
        userInfo.setCity(userCity);
        userInfo.setCountry(userCountry);
        userInfo.setSocialLink(userSocialLink);
        userInfo.setDateOfRegistration(userDateOfBirth);
        userInfo.setUserId(user.getId());

        userDAO.addAdditionalInfo(userInfo);
        System.out.println("info added");
        response.sendRedirect(request.getContextPath() + CommandPageRedirect.MAIN_PAGE);
    }

}
