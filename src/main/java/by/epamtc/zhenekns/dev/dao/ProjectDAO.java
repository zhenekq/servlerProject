package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.Project;

public interface ProjectDAO {

    Project addNewProject(Project project);
    Project deleteProject(Project project);
    Project updateProject(Project project);

}
