package by.epamtc.zhenekns.dev.service.command.event.get;

import by.epamtc.zhenekns.dev.service.command.Command;
import by.epamtc.zhenekns.dev.service.command.CommandPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizedMainPage implements Command {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(CommandPage.AUTHORIZED_MAIN_PAGE_JSP)
                .forward(request,response);
    }
}
