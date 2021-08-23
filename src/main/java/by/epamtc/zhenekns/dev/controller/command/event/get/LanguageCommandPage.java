package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LanguageCommandPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setAttribute("language", request.getParameter("language"));
        String refer = request.getHeader("Referer");
        response.sendRedirect(refer);
    }
}
