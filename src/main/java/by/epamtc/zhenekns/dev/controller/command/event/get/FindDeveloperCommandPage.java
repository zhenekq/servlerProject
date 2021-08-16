package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindDeveloperCommandPage implements Command {

    private final Logger logger = LogManager.getLogger();
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> allDevelopers = null;
        List<User> developers = new ArrayList<>();
        try {
            allDevelopers = userService.getAllUsersByRole(Role.DEVELOPER);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        for (User developer : allDevelopers) {
            UserInfo userInfo = null;
            try {
                userInfo = userService.getAllInfoAboutUserById(developer.getId());
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            developer.setUserInfo(userInfo);
            if(developer.getUserInfo().getStatus().equals("FREE")){
                developers.add(developer);
            }
        }
        request.setAttribute("developers", developers);
        request.getRequestDispatcher(CommandPage.FIND_DEVELOPER).forward(request, response);
    }
}
