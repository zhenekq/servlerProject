package by.epamtc.zhenekns.dev.service.validation;

import by.epamtc.zhenekns.dev.service.validation.implementation.UserValidationImpl;

public class ValidationFactory {
    private static final ValidationFactory instance = new ValidationFactory();

    private ValidationFactory(){}

    private EntityValidation userValidation = new UserValidationImpl();

    public EntityValidation getUserValidation() {
        return userValidation;
    }
}
