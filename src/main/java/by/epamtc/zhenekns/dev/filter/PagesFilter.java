package by.epamtc.zhenekns.dev.filter;

import by.epamtc.zhenekns.dev.controller.command.CommandName;
import by.epamtc.zhenekns.dev.controller.command.CommandPage;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagesFilter implements Filter {

    private final Map<Role, List<CommandName>> pagesFilter = new HashMap<>();

    public PagesFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
        List<CommandName> guestPages = Arrays.asList(
                CommandName.AUTHORIZATION,
                CommandName.AUTHORIZATION_PAGE,
                CommandName.REGISTRATION,
                CommandName.REGISTRATION_PAGE,
                CommandName.MAIN_PAGE,
                CommandName.LOGOUT_PAGE
        );
        pagesFilter.put(Role.USER, guestPages);

        List<CommandName> commonPages = Arrays.asList(
                CommandName.AUTHORIZED_MAIN_PAGE,
                CommandName.USER_PROFILE,
                CommandName.PROJECT_INFO,
                CommandName.PROFILE,
                CommandName.SHOW_PROJECT,
                CommandName.LOGOUT_PAGE,
                CommandName.UPDATE_PROFILE
        );

        List<CommandName> managerPages = Arrays.asList(
                CommandName.AUTHORIZED_MAIN_PAGE,
                CommandName.USER_PROFILE,
                CommandName.PROJECT_INFO,
                CommandName.PROFILE,
                CommandName.SHOW_PROJECT,
                CommandName.LOGOUT_PAGE,
                CommandName.ADDITIONAL_INFO,
                CommandName.ADDITIONAL_INFO_PAGE,
                CommandName.FIND_DEVELOPER,
                CommandName.MANAGED_PROJECTS,
                CommandName.MANAGER_TEAMS,
                CommandName.PROJECT_REQUESTS,
                CommandName.CREATE_NEW_TASK,
                CommandName.RESPONSE_FOR_PROJECT,
                CommandName.ADD_NEW_TASK,
                CommandName.ADD_NEW_TEAM,
                CommandName.EDIT_PROJECT_REQUEST,
                CommandName.UPDATE_PROJECT_REQUEST,
                CommandName.UPDATE_PROFILE,
                CommandName.ADD_TO_TEAM_PAGE,
                CommandName.ADD_TO_TEAM,
                CommandName.CREATE_NEW_TEAM,
                CommandName.UPDATE_TEAM,
                CommandName.UPDATE_TEAM_PAGE,
                CommandName.DELETE_TEAMMATE,
                CommandName.SHOW_TEAM,
                CommandName.VIEW_TASKS,
                CommandName.UPDATE_TASK,
                CommandName.EDIT_TASK
        );
        pagesFilter.put(Role.MANAGER, managerPages);

        List<CommandName> customerPages = Arrays.asList(
                //====
                CommandName.AUTHORIZED_MAIN_PAGE,
                CommandName.USER_PROFILE,
                CommandName.PROJECT_INFO,
                CommandName.PROFILE,
                CommandName.SHOW_PROJECT,
                CommandName.LOGOUT_PAGE,
                CommandName.UPDATE_PROFILE,
                CommandName.ADDITIONAL_INFO,
                CommandName.ADDITIONAL_INFO_PAGE,
                CommandName.SHOW_TEAM,
                //=====
                CommandName.SHOW_MY_PROJECTS,
                CommandName.CUSTOMER_PROJECT_RESPONSES,
                CommandName.ADD_NEW_PROJECT_PAGE,
                CommandName.ADD_NEW_PROJECT,
                CommandName.APPROVE_PROJECT_REQUEST,
                CommandName.REJECT_PROJECT_REQUEST,
                CommandName.EDIT_PROJECT,
                CommandName.CLOSE_REQUESTS_FOR_PROJECT,
                CommandName.UPDATE_PROJECT,
                CommandName.SHOW_TEAM
        );
        pagesFilter.put(Role.CUSTOMER, customerPages);

        List<CommandName> developerPages = Arrays.asList(
                CommandName.AUTHORIZED_MAIN_PAGE,
                CommandName.USER_PROFILE,
                CommandName.PROJECT_INFO,
                CommandName.PROFILE,
                CommandName.SHOW_PROJECT,
                CommandName.LOGOUT_PAGE,
                CommandName.UPDATE_PROFILE,
                CommandName.DEVELOPER_TASKS,
                CommandName.COMPLETE_TASK_PAGE,
                CommandName.COMPLETE_TASK,
                CommandName.ADDITIONAL_INFO,
                CommandName.ADDITIONAL_INFO_PAGE,
                CommandName.SHOW_TEAM
                );
        pagesFilter.put(Role.DEVELOPER, developerPages);

        List<CommandName> adminPages = Arrays.asList(
                CommandName.AUTHORIZED_MAIN_PAGE,
                CommandName.USER_PROFILE,
                CommandName.PROJECT_INFO,
                CommandName.PROFILE,
                CommandName.SHOW_PROJECT,
                CommandName.LOGOUT_PAGE,
                CommandName.UPDATE_PROFILE,
                CommandName.ADDITIONAL_INFO,
                CommandName.ADDITIONAL_INFO_PAGE,

                CommandName.AUTHORIZED_MAIN_PAGE,
                CommandName.ADMIN_PROJECTS,
                CommandName.ADMIN_PROJECT_RESPONSES,
                CommandName.ADMIN_TASKS,
                CommandName.ADMIN_TEAMS,
                CommandName.OPEN_REQUESTS_FOR_PROJECT,
                CommandName.CLOSE_REQUESTS_FOR_PROJECT,
                CommandName.BLOCK_USER,
                CommandName.UNBLOCK_USER,
                CommandName.EDIT_USER,
                CommandName.EDIT_PROJECT,
                CommandName.UPDATE_PROJECT,
                CommandName.FIND_USER,
                CommandName.SHOW_TEAM,
                CommandName.VIEW_TASKS
        );

        pagesFilter.put(Role.ADMIN, adminPages);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession(true).getAttribute("user");
        Role role = null;
        if (user == null) {
            role = Role.USER;
        } else {
            role = Role.valueOf(user.getRole().toUpperCase());
        }
        String command = request.getParameter("command");
        if (command == null) {
            request.getRequestDispatcher(CommandPage.ERROR_PAGE).forward(request, response);
        } else {
            if (!pagesFilter.get(role).contains(CommandName.valueOf(command.toUpperCase()))) {
                if (isCommandEnable(CommandName.valueOf(command.toUpperCase()))) {
                    request.getRequestDispatcher(CommandPage.ERROR_PAGE).forward(request, response);
                } else {
                    request.getRequestDispatcher(CommandPage.ERROR_PAGE).forward(request, response);
                }
            } else {
                chain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    private boolean isCommandEnable(CommandName command) {
        for (Map.Entry<Role, List<CommandName>> element : pagesFilter.entrySet()) {
            if (element.getValue().contains(command)) {
                return true;
            }
        }
        return false;
    }

    public void destroy() {

    }

}
