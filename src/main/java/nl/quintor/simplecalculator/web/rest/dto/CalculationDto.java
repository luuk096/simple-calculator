package nl.quintor.simplecalculator.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.quintor.simplecalculator.helpers.enums.Operator;
import nl.quintor.simplecalculator.web.validation.constraint.NotZeroWhenDividing;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotZeroWhenDividing
public class CalculationDto {

    private int leftOperand;
    @NotNull(message = "Supported operators are: 'Add', 'Subtract', 'Multiply', 'Divide'.")
    private Operator operator;
    private int rightOperand;

}
