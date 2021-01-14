package nl.quintor.simplecalculator.model;

import lombok.Data;
import nl.quintor.simplecalculator.helpers.enums.Operator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Calculation")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double leftOperand;
    private Operator operator;
    private double rightOperand;
    private double result;

    public Calculation setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
        return this;
    }

    public Calculation setOperator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public Calculation setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
        return this;
    }

    public Calculation setResult(double result) {
        this.result = result;
        return this;
    }

}
