package by.epamtc.zhenekns.dev.service;

import by.epamtc.zhenekns.dev.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project getProjectById(int id);
}
