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
    private double x;
    private Operator operator;
    private double y;
    private double result;

    public Calculation setX(double x) {
        this.x = x;
        return this;
    }

    public Calculation setOperator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public Calculation setY(double x) {
        this.y = y;
        return this;
    }

    public Calculation setResult(double result) {
        this.result = result;
        return this;
    }

}
