package by.epamtc.zhenekns.dev.dao.impl;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.dao.DAOFactory;
import by.epamtc.zhenekns.dev.dao.UserDAO;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {

    private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

    @BeforeAll
    static void initConnectionPool() {
        ConnectionPool.getConnectionPool();
    }

    @Test
    void testFindUserById() throws DaoException {
        User user = userDAO.getUserById(1);
        User expectedUser = new User();
        expectedUser.setId(1);
        expectedUser.setEmail("m@m.ru");
        expectedUser.setNickname("manager1");
        expectedUser.setPassword("manager");
        expectedUser.setRole(Role.MANAGER);
        assertEquals(user, expectedUser);
    }
}
