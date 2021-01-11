package nl.quintor.simplecalculator.web.validation;

import nl.quintor.simplecalculator.web.validation.constraint.NotZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotZeroValidator implements ConstraintValidator<NotZero, Integer> {

    @Override
    public void initialize(NotZero constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        return number != 0;
    }

}
