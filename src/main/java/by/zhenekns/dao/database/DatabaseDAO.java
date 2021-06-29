package by.zhenekns.dao.database;

import by.zhenekns.entity.User;

public interface DatabaseDAO {

    void add(User user);

    void delete(User user);
}
