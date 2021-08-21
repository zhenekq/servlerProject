package by.epamtc.zhenekns.dev.dao.connection;

import by.epamtc.zhenekns.dev.connection.ConnectionPool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionPoolTest {

    @BeforeAll
    static void initConnectionPool(){
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
    }

    @Test
    void testIsIdentTwoConnectionPools(){
        ConnectionPool firstPool = ConnectionPool.getConnectionPool();
        ConnectionPool secondPool = ConnectionPool.getConnectionPool();

        assertEquals(firstPool, secondPool);
    }

}
