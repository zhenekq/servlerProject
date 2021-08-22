package by.epamtc.zhenekns.dev.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LocaleFilter implements Filter {

    private final static String ENGLISH = "en";
    private final static String LOCALE = "language";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String localeLanguage = (String) request.getSession().getAttribute(LOCALE);

        if(localeLanguage == null){
            request.getSession().setAttribute(LOCALE, ENGLISH);
        }
        if(localeLanguage.equals("en")){
            request.getSession().setAttribute(LOCALE, localeLanguage);
        }


    }

    private String removeLanguageParameter(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder requestString = new StringBuilder(request.getContextPath() + "/online-shop?");
        parameterMap.entrySet().stream()
                .filter(e -> !LOCALE.equals(e.getKey()))
                .forEach(e -> requestString.append(e.getKey()).append("=").append(e.getValue()[0]).append("&"));
        requestString.deleteCharAt(requestString.length() - 1);
        return requestString.toString();
    }

    @Override
    public void destroy() {

    }
}
