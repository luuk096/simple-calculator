package nl.quintor.simplecalculator.web.rest.dto;

import lombok.Data;
import nl.quintor.simplecalculator.web.validation.constraint.NotZero;

@Data
public class DivisionDto {

    private int dividend;
    @NotZero(message = "Division by zero is undefined")
    private int divisor;

}
