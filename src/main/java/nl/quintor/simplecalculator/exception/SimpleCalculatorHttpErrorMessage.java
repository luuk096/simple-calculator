package nl.quintor.simplecalculator.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleCalculatorHttpErrorMessage {
    private String field;
    private String type;
    private String message;

}
