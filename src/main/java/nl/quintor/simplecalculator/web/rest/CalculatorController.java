package nl.quintor.simplecalculator.web.rest;

import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.service.CalculatorService;
import nl.quintor.simplecalculator.web.rest.dto.*;
import nl.quintor.simplecalculator.web.transformer.CalculationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calculator")
@CrossOrigin
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final CalculationMapper calculateTransformer;

    public CalculatorController(CalculatorService calculatorService, CalculationMapper calculateTransformer) {
        this.calculatorService = calculatorService;
        this.calculateTransformer = calculateTransformer;
    }

    @GetMapping("/results")
    public ResponseEntity<List<CalculationResultDto>> findAll() {
        return ResponseEntity.ok(calculatorService.findAll().stream()
                .map(c -> calculateTransformer.CalculationtoCalculationResultDto(c))
                .collect(Collectors.toList()));
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResultDto> calculate(@Valid @RequestBody CalculationDto calculationDto) {
        Calculation calculation = calculatorService
                .calculate(calculationDto.getLeftOperand(), calculationDto.getOperator(), calculationDto.getRightOperand());
        return ResponseEntity.ok(calculateTransformer.CalculationtoCalculationResultDto(calculation));
    }

}
