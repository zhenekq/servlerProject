package by.zhenekns.service.command.post.event;

import by.zhenekns.dao.DAOFactory;
import by.zhenekns.dao.database.DatabaseDAO;
import by.zhenekns.entity.User;
import by.zhenekns.service.command.post.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private static DAOFactory factory = DAOFactory.getInstance();
    private static DatabaseDAO databaseDAO = factory.getDatabaseDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("REGISTRATION");
        String email = request.getParameter("email");
        String username = request.getParameter("nickname");
        String password = request.getParameter("password");
        System.out.println(email + username + password);
        //databaseDAO.add(new User(email,username,password));
    }
}
