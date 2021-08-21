package by.epamtc.zhenekns.dev.service.impl;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ProjectService;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectServiceTest {

    private final Logger logger = LogManager.getLogger();
    private final ProjectService projectService = ServiceFactory.getInstance().getProjectService();


    @BeforeAll
    static void initConnectionPool() {
        ConnectionPool.getConnectionPool();
    }

    @Test
    void testFindProjectById() throws ServiceException {
        Project project = projectService.getProjectById(25);
        Project expectedProject = new Project();
        expectedProject.setId(25);
        expectedProject.setTitle("TWESDFS");
        expectedProject.setDescription("TWESDFS");
        expectedProject.setQualification("TWESDFS");
        expectedProject.setTeamSize(20);
        expectedProject.setCost(120);
        expectedProject.setDeadline("20.02.2003");
        expectedProject.setUser_id(2);
        expectedProject.setStatus("CLOSED_FOR_REQUESTS");
        assertEquals(project, expectedProject);
    }

}
