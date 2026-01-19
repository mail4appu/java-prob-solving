package validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class MainApp {

    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        User user = new User("null");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        System.out.println(violations.size());
    }
}
