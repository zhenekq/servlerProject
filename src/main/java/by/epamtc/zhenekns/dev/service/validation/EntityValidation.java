package by.epamtc.zhenekns.dev.service.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface EntityValidation<Entity> {

    boolean createValidation(Entity entity);
    boolean updateValidation(Entity entity);

    default boolean isValidString(String string, String patternRegex){
        boolean isValid = false;
        if(string != null){
            Pattern pattern = Pattern.compile(patternRegex);
            Matcher matcher = pattern.matcher(string);
            isValid = matcher.matches();
        }
        return isValid;
    }
}
