package by.epamtc.zhenekns.dev.dao.impl;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.ProjectDAO;
import by.epamtc.zhenekns.dev.entity.Project;
import by.epamtc.zhenekns.dev.exception.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectDaoTest {

    private final ProjectDAO projectDAO = DAOFactory.getInstance().getProjectDAO();

    @BeforeAll
    static void initConnectionPool() {
        ConnectionPool.getConnectionPool();
    }

    @Test
    void testFindProjectById() throws DaoException {
        Project project = projectDAO.getProjectById(25);
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
