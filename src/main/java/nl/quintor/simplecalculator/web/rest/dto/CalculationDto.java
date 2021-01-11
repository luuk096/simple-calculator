package nl.quintor.simplecalculator.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.quintor.simplecalculator.helpers.enums.Operator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationDto {

    private Long id;
    private double x;
    private Operator operator;
    private double y;
    private double result;

}
