package nl.quintor.simplecalculator.service;

import nl.quintor.simplecalculator.helpers.enums.Operator;
import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.repository.CalculatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public Calculation calculate(int leftOperand, Operator operator, int rightOperand) {
        double result = 0;
        switch (operator) {
            case Add:
                result = add(leftOperand, rightOperand);
                break;
            case Subtract:
                result = subtract(leftOperand, rightOperand);
                break;
            case Multiply:
                result = multiply(leftOperand, rightOperand);
                break;
            case Divide:
                result = divide(leftOperand, rightOperand);
                break;
            default:
                break;
        }

        Calculation calculation = new Calculation()
                .setLeftOperand(leftOperand)
                .setOperator(operator)
                .setRightOperand(rightOperand)
                .setResult(result);
        return calculatorRepository.save(calculation);
    }

    private double add(int addend, int augend) {
        return addend + augend;
    }

    private double subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    private double multiply(int multiplier, int multiplicand) {
        return multiplier * multiplicand;
    }

    private double divide(int dividend, int divisor) {
        return (double) dividend / divisor;
    }

    public List<Calculation> findAll() {
        return calculatorRepository.findAll();
    }

}
