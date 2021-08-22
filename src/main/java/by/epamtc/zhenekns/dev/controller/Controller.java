package by.epamtc.zhenekns.dev.controller;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final CommandProvider provider = CommandProvider.getInstance();

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession(true).getAttribute("language"));
        process(request, response);
    }

    private static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandName = request.getParameter("command");
        Command command = provider.getCommand(commandName);
        command.execute(request, response);

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
