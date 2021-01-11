package nl.quintor.simplecalculator.web.rest;

import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.service.CalculatorService;
import nl.quintor.simplecalculator.web.rest.dto.*;
import nl.quintor.simplecalculator.web.transformer.CalculationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final CalculationMapper calculateTransformer;

    public CalculatorController(CalculatorService calculatorService, CalculationMapper calculateTransformer) {
        this.calculatorService = calculatorService;
        this.calculateTransformer = calculateTransformer;
    }

    @GetMapping
    public ResponseEntity<List<CalculationDto>> findAll() {
        return ResponseEntity.ok(calculatorService.findAll().stream()
                .map(c -> calculateTransformer.CalculationtoCalculationDto(c))
                .collect(Collectors.toList()));
    }

    @PostMapping("/add")
    public ResponseEntity<CalculationDto> add(@RequestBody AdditionDto additionDto) {
        Calculation calculation = calculatorService.add(additionDto.getAugend(), additionDto.getAddend());
        return ResponseEntity.ok(calculateTransformer.CalculationtoCalculationDto(calculation));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationDto> subtract(@RequestBody SubtractionDto subtractionDto) {
        Calculation calculation = calculatorService.subtract(subtractionDto.getMinuend(), subtractionDto.getSubtrahend());
        System.out.println(calculation);
        return ResponseEntity.ok(calculateTransformer.CalculationtoCalculationDto(calculation));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculationDto> multiply(@RequestBody MultiplicationDto multiplicationDto) {
        Calculation calculation = calculatorService.multiply(multiplicationDto.getMultiplicand(), multiplicationDto.getMultiplier());
        return ResponseEntity.ok(calculateTransformer.CalculationtoCalculationDto(calculation));
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculationDto> divide(@Valid @RequestBody DivisionDto divisionDto) {
        Calculation calculation = calculatorService.divide(divisionDto.getDividend(), divisionDto.getDivisor());
        return ResponseEntity.ok(calculateTransformer.CalculationtoCalculationDto(calculation));
    }

}
