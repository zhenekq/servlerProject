package by.epamtc.zhenekns.dev.filter;

import by.epamtc.zhenekns.dev.controller.command.CommandPage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String loginURI = request.getContextPath() + "servlet?command=authorization_page";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = (request.getRequestURI() + "?command=authorization_page").equals(loginURI);
        System.out.println("LOGIN URI: " + loginURI);
        System.out.println("REQUEST URI: " + (request.getRequestURI().replace('/', ' ')).trim() + "?command=authorization_page");
        System.out.println("IS LOGGED IN: " + loggedIn);
        System.out.println("IS LOGIN REQUEST: " + loginRequest);

        if (loggedIn || loginRequest) {
            System.out.println("there");
            chain.doFilter(request, response);
        } else {
            System.out.println("there2");
            request.getRequestDispatcher(CommandPage.AUTHORIZATION_PAGE_JSP).forward(request, response);
        }
    }


    /*private boolean isLoginRequired() {
        String requestURL = request.getRequestURL().toString();

        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }

        return false;
    }
*/
    public AuthFilter() {
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
