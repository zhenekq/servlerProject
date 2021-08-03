package by.epamtc.zhenekns.dev.service.command.event.post;

import by.epamtc.zhenekns.dev.dao.UserDAO;
import by.epamtc.zhenekns.dev.dao.implementation.UserDAOImpl;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProfileCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        UserService userService = new UserServiceImpl();
        UserInfo userInfo = userService.getAllInfoAboutUserById(user.getId());
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String experience = request.getParameter("experience");
        String socialLink = request.getParameter("social_link");
        String date = request.getParameter("date");
        String about = request.getParameter("about");

        userInfo.setCountry(country);
        userInfo.setCity(city);
        userInfo.setExperience(experience);
        userInfo.setSocialLink(socialLink);
        userInfo.setDateOfRegistration(date);
        userInfo.setQualification(about);
        System.out.println(userInfo.getId());
        user.setUserInfo(userInfo);

        UserDAO userDAO = new UserDAOImpl();

        userDAO.updateUser(user);
        response.sendRedirect(request.getContextPath() + "?command=authorized_main_page");
    }
}
