package by.epamtc.zhenekns.dev.controller.command.event.get;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTeamCommandPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int teamId = Integer.parseInt(request.getParameter("id"));

    }
}
