package by.epamtc.zhenekns.dev.dao.user;

import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;

public interface UserDAO {
    
    User addUser(User user);
    User deleteUser(User user);
    User updateUser(User user);
    

}
