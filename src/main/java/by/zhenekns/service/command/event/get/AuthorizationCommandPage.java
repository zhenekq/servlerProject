package by.zhenekns.service.command.event.get;

import by.zhenekns.service.command.Command;
import by.zhenekns.service.command.CommandPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationCommandPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(CommandPage.AUTHORIZATION_PAGE_JSP).forward(request,response);
    }
}
