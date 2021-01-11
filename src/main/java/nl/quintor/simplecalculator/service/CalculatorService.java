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

    public Calculation add(int x, int y) {
        double result = x + y;
        Calculation calculation = new Calculation()
                .setX(x)
                .setOperator(Operator.Add)
                .setY(y)
                .setResult(result);
        calculatorRepository.save(calculation);
        return calculation;
    }

    public Calculation subtract(int x, int y) {
        double result = x - y;
        Calculation calculation = new Calculation()
                .setX(x)
                .setOperator(Operator.Subtract)
                .setY(y)
                .setResult(result);
        calculatorRepository.save(calculation);
        return calculation;
    }

    public Calculation multiply(int x, int y) {
        double result = x * y;
        Calculation calculation = new Calculation()
                .setX(x)
                .setOperator(Operator.Multiply)
                .setY(y)
                .setResult(result);
        calculatorRepository.save(calculation);
        return calculation;
    }

    public Calculation divide(int x, int y) {
        double result = x / y;
        Calculation calculation = new Calculation()
                .setX(x)
                .setOperator(Operator.Divide)
                .setY(y)
                .setResult(result);
        calculatorRepository.save(calculation);
        return calculation;
    }

    public List<Calculation> findAll() {
        return calculatorRepository.findAll();
    }

}
