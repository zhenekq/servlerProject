package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.service.implementation.*;

import javax.print.attribute.standard.OrientationRequested;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory(){}

    private final UserService userService = new UserServiceImpl();
    private final ProjectService projectService = new ProjectServiceImpl();
    private final ProjectResponseService projectResponseService = new ProjectResponseServiceImpl();
    private final TeamService teamService = new TeamServiceImpl();
    private final TaskService taskService = new TaskServiceImpl();

    public UserService getUserService(){
        return userService;
    }

    public ProjectService getProjectService(){
        return projectService;
    }

    public ProjectResponseService getProjectResponseService() {
        return projectResponseService;
    }

    public TeamService getTeamService() {
        return teamService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
