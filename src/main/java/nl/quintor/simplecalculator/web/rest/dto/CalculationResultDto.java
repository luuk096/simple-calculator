package nl.quintor.simplecalculator.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.quintor.simplecalculator.helpers.enums.Operator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationResultDto {

    private Long id;
    private int leftOperand;
    private Operator operator;
    private int rightOperand;
    private double result;

}
