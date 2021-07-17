package by.zhenekns.dao.database;

import by.zhenekns.entity.User;

public interface DatabaseDAO {

    void add(User user);

    boolean isUserExists(User user);

}
