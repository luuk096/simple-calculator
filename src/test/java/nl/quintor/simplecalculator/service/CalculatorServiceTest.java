package nl.quintor.simplecalculator.service;

import nl.quintor.simplecalculator.helpers.enums.Operator;
import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.repository.CalculatorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @InjectMocks
    private CalculatorService calculatorService;

    @Mock
    private CalculatorRepository calculatorRepository;

    @Test
    public void calculateAddTest() {
        int leftOperand = 5;
        Operator operator = Operator.Add;
        int rightOperand = 18;
        double expectedResult = 23;

        var expectedCalculation = new Calculation()
                .setLeftOperand(leftOperand)
                .setOperator(operator)
                .setRightOperand(rightOperand)
                .setResult(expectedResult);

        when(calculatorRepository.save(any(Calculation.class))).thenReturn(expectedCalculation);

        var actualCalculation = calculatorService.calculate(leftOperand, operator, rightOperand);

        assertEquals(expectedCalculation, actualCalculation);
        verify(calculatorRepository, times(1)).save(eq(expectedCalculation));
    }

    @Test
    public void calculateSubtractTest() {
        int leftOperand = 965;
        Operator operator = Operator.Subtract;
        int rightOperand = 44522;
        double expectedResult = -43557;

        var expectedCalculation = new Calculation()
                .setLeftOperand(leftOperand)
                .setOperator(operator)
                .setRightOperand(rightOperand)
                .setResult(expectedResult);

        when(calculatorRepository.save(any(Calculation.class))).thenReturn(expectedCalculation);

        var actualCalculation = calculatorService.calculate(leftOperand, operator, rightOperand);

        assertEquals(expectedCalculation, actualCalculation);
        verify(calculatorRepository, times(1)).save(eq(expectedCalculation));
    }

    @Test
    public void calculateMultiplyTest() {
        int leftOperand = 20;
        Operator operator = Operator.Multiply;
        int rightOperand = 5;
        double expectedResult = 100;

        var expectedCalculation = new Calculation()
                .setLeftOperand(leftOperand)
                .setOperator(operator)
                .setRightOperand(rightOperand)
                .setResult(expectedResult);

        when(calculatorRepository.save(any(Calculation.class))).thenReturn(expectedCalculation);

        var actualCalculation = calculatorService.calculate(leftOperand, operator, rightOperand);

        assertEquals(expectedCalculation, actualCalculation);
        verify(calculatorRepository, times(1)).save(eq(expectedCalculation));
    }

    @Test
    public void calculateDivideTest() {
        int leftOperand = 20;
        Operator operator = Operator.Divide;
        int rightOperand = 3;
        double expectedResult = 6.666666666666667;

        var expectedCalculation = new Calculation()
                .setLeftOperand(leftOperand)
                .setOperator(operator)
                .setRightOperand(rightOperand)
                .setResult(expectedResult);

        when(calculatorRepository.save(any(Calculation.class))).thenReturn(expectedCalculation);

        var actualCalculation = calculatorService.calculate(leftOperand, operator, rightOperand);

        assertEquals(expectedCalculation, actualCalculation);
        verify(calculatorRepository, times(1)).save(eq(expectedCalculation));
    }

}
