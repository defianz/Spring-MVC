package me.defian.demowebmvc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event  event = (Event) target;
        if(event.getName().equalsIgnoreCase("aaa")){
            errors.rejectValue("name","wrongValue","the value is now allowed");
        }
    }
}
