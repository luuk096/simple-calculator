package nl.quintor.simplecalculator.web.validation;

import nl.quintor.simplecalculator.helpers.enums.Operator;
import nl.quintor.simplecalculator.web.rest.dto.CalculationDto;
import nl.quintor.simplecalculator.web.validation.constraint.NotZeroWhenDividing;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotZeroWhenDividingValidator implements ConstraintValidator<NotZeroWhenDividing, CalculationDto> {

    @Override
    public void initialize(NotZeroWhenDividing constraintAnnotation) {

    }

    @Override
    public boolean isValid(CalculationDto calculationDto, ConstraintValidatorContext constraintValidatorContext) {
        if (calculationDto.getOperator() == Operator.Divide) {
            return calculationDto.getRightOperand() != 0;
        }
        return true;
    }

}
