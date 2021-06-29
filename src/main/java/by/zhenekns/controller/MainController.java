package by.zhenekns.controller;

import by.zhenekns.service.command.post.Command;
import by.zhenekns.service.command.post.CommandProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final CommandProvider provider = CommandProvider.getInstance();

    public MainController() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
        String commandName;
        Command command;
        commandName = request.getParameter("command");
        command = provider.getCommand(commandName);
        command.execute(request, response);
        doGet(request,response);
    }
}
