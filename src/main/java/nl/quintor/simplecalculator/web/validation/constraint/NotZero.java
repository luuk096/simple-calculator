package nl.quintor.simplecalculator.web.validation.constraint;

import nl.quintor.simplecalculator.web.validation.NotZeroValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = NotZeroValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotZero {
    String message() default "Zero is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
