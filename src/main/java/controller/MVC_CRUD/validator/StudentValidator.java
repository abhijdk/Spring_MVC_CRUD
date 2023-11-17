package controller.MVC_CRUD.validator;

import controller.MVC_CRUD.pojo.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Student student=(Student) target;


        String name=student.getName()+" ";
        String address=student.getAddress();
        String moible=student.getMobile();

        /*Validate Name , either name starts with capital or not
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","student.name.empty");
        if(Character.isLowerCase(name.charAt(0))){
            errors.rejectValue("name","student.name.invalid","Invalid name format");
        }

        /*Validate Mobile number should be 10 digit or not
        */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mobile","student.mobile.empty");
        if(!Pattern.compile("^[6789]\\d{9}$").matcher(moible).matches()){
            errors.rejectValue("mobile","student.mobile.invalid","Invalid mobile format");
        }

        /*Validate Address , either Address starts with capital or not
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address","student.address.empty");
        if(address.length()<5 ){
            errors.rejectValue("address","student.address.invalid","Invalid address format");
        }
    }
}