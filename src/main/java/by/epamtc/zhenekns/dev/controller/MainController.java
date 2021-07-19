package by.epamtc.zhenekns.dev.controller;

import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.user.UserDAO;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandProvider;
import by.epamtc.zhenekns.dev.service.user.UserService;
import by.epamtc.zhenekns.dev.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final CommandProvider provider = CommandProvider.getInstance();
    private UserService userService = new UserServiceImpl();

    public MainController() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
        System.out.println("GET REQUEST");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
        System.out.println("POST REQUEST");

    }

    private static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandName = request.getParameter("command");
        Command command = provider.getCommand(commandName);
        command.execute(request, response);
    }
}
