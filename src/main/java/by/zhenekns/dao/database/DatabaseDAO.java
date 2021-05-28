package by.zhenekns.dao.database;

import by.zhenekns.entity.User;

public interface DatabaseDAO {
    void connect();
    void add(User user);
    void delete(User user);
}
