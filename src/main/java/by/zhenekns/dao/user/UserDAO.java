package by.zhenekns.dao.user;

import by.zhenekns.entity.User;

public interface UserDAO {
    void registration(User user);
    void login(User user);
}
