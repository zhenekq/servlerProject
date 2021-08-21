package by.epamtc.zhenekns.dev.service.impl;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.exception.ServiceException;
import by.epamtc.zhenekns.dev.service.ServiceFactory;
import by.epamtc.zhenekns.dev.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final Logger logger = LogManager.getLogger();

    @BeforeAll
    static void initConnectionPool() {
        ConnectionPool.getConnectionPool();
    }

    @Test
    void testFindUserById() throws ServiceException {
        User user = userService.getUserById(1);
        User expectedUser = new User();
        expectedUser.setId(1);
        expectedUser.setEmail("m@m.ru");
        expectedUser.setNickname("manager1");
        expectedUser.setPassword("manager");
        expectedUser.setRole(Role.MANAGER);
        assertEquals(user, expectedUser);
    }

}
