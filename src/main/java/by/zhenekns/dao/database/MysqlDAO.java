package by.zhenekns.dao.database;

import by.zhenekns.entity.User;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDAO implements DatabaseDAO {
    @Override
    public void connect() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void add(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
