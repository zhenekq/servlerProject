package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.entity.User;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    Map<Project, User> getAllProjects();

    Project getProjectById(int id);
    List<Project> getProjectsByUserId(int id);
}
