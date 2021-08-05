package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.service.implementation.ProjectResponseServiceImpl;
import by.epamtc.zhenekns.dev.service.implementation.ProjectServiceImpl;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

import javax.print.attribute.standard.OrientationRequested;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory(){}

    private final UserService userService = new UserServiceImpl();
    private final ProjectService projectService = new ProjectServiceImpl();
    private final ProjectResponseService projectResponseService = new ProjectResponseServiceImpl();


    public UserService getUserService(){
        return userService;
    }

    public ProjectService getProjectService(){
        return projectService;
    }

    public ProjectResponseService getProjectResponseService() {
        return projectResponseService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
