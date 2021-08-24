package by.epamtc.zhenekns.dev.service.validation.implementation;

import by.epamtc.zhenekns.dev.entity.Task;
import by.epamtc.zhenekns.dev.service.validation.EntityValidation;
import org.w3c.dom.Entity;

public class TaskValidation implements EntityValidation<Task> {

    @Override
    public boolean createValidation(Task task) {
        return false;
    }

    @Override
    public boolean updateValidation(Task task) {
        return false;
    }
}
