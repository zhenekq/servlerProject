package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.service.implementation.ProjectServiceImpl;
import by.epamtc.zhenekns.dev.service.implementation.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory(){}

    public static UserService getUserService(){
        return new UserServiceImpl();
    }

    public static ProjectService getProjectService(){
        return new ProjectServiceImpl();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
