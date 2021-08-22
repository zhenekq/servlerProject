package by.epamtc.zhenekns.dev.service.validation.implementation;

import by.epamtc.zhenekns.dev.entity.User;
import by.epamtc.zhenekns.dev.service.validation.EntityValidation;

public class UserValidationImpl implements EntityValidation<User> {

    @Override
    public boolean createValidation(User user) {
        return false;
    }

    @Override
    public boolean updateValidation(User user) {
        return false;
    }
}
