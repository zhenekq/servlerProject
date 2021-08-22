package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LanguageCommandPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String language = request.getParameter("language");
        System.out.println(language);
        if(language.equals("en") || language.equals("ru")){
            request.getSession(true).setAttribute("language", language);
            response.sendRedirect(CommandPageRedirect.AUTHORIZED_MAIN_PAGE);
        }
    }
}
