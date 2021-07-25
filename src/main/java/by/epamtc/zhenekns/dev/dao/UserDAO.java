package by.epamtc.zhenekns.dev.dao;

import by.epamtc.zhenekns.dev.entity.Role;
import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.entity.UserInfo;

public interface UserDAO {
    
    User addUser(User user);
    User deleteUser(User user);
    User updateUser(User user);
    UserInfo addAdditionalInfo(UserInfo userInfo);

}
