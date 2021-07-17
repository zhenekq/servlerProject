package by.zhenekns.service.command.event.get;

import by.zhenekns.service.command.Command;
import by.zhenekns.service.command.CommandPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainCommandPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommandPage.MAIN_PAGE_JSP);
        requestDispatcher.forward(request,response);
    }
}
