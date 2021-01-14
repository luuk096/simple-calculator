package nl.quintor.simplecalculator.web.validation.constraint;

import nl.quintor.simplecalculator.web.validation.NotZeroWhenDividingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = NotZeroWhenDividingValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotZeroWhenDividing {
    String message() default "Zero is invalid when dividing";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
