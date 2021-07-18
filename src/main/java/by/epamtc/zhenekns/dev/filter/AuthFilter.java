/*
package by.epamtc.zhenekns.dev.filter;

import by.epamtc.zhenekns.dev.service.SessionAttributes;
import by.epamtc.zhenekns.dev.service.command.CommandPage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthFilter implements Filter {

    private HttpServletRequest request;

    private static final String[] loginRequiredURLs = {
            "?command=values", "/edit_profile", "/update_profile"
    };

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute(SessionAttributes.SESSION_USERNAME) != null);
        String value = "command=authorization_page";
        boolean isLoginRequest = request.getQueryString().equals(value);
        System.out.println(value);
        //System.out.println("URI: " + httpRequest.getRequestURL());
        System.out.println("IS LOGGED_IN: " + isLoggedIn);
        System.out.println("IS isLoginRequest: " + isLoginRequest);
        //System.out.println("IS isLoginPage: " + isLoginPage);
        if (isLoggedIn && (isLoginRequest)) {
            request.getRequestDispatcher(CommandPage.MAIN_PAGE_JSP).forward(request, response);
            System.out.println("There");
        } else if (!isLoggedIn && isLoginRequired()) {
            System.out.println("There 2");
            RequestDispatcher dispatcher = request.getRequestDispatcher(CommandPage.AUTHORIZATION_PAGE_JSP);
            dispatcher.forward(request, response);
        } else {
            System.out.println("there 3");
            chain.doFilter(request, response);
        }
    }


    private boolean isLoginRequired() {
        String requestURL = request.getRequestURL().toString();

        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }

        return false;
    }

    public AuthFilter() {
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
*/
