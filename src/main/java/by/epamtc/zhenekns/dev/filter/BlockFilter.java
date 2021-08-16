package by.epamtc.zhenekns.dev.filter;

import by.epamtc.zhenekns.dev.controller.command.CommandName;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.controller.command.CommandPageRedirect;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import by.epamtc.zhenekns.dev.status.UserStatus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/servlet")
public class BlockFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private final Logger logger = LogManager.getLogger();
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession(true).getAttribute("user");
        System.out.println(user);
        if (user == null) {
            filterChain.doFilter(request, response);
        } else {
            UserInfo userInfo = null;
            try {
                userInfo = userService.getAllInfoAboutUserById(user.getId());
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            if (userInfo.getStatus().equals(UserStatus.USER_STATUS_BLOCKED)) {
                if (request.getParameter("command").toUpperCase().equals(CommandName.LOGOUT_PAGE.toString())) {
                    request.getSession().invalidate();
                    response.sendRedirect(CommandPageRedirect.MAIN_PAGE);
                } else {
                    request.getRequestDispatcher(CommandPage.BLOCKED_USER).forward(request, response);
                }
            } else {
                filterChain.doFilter(request, response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
