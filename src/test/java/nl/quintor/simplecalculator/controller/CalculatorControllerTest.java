package nl.quintor.simplecalculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.quintor.simplecalculator.helpers.enums.Operator;
import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.service.CalculatorService;
import nl.quintor.simplecalculator.web.rest.CalculatorController;
import nl.quintor.simplecalculator.web.rest.dto.CalculationDto;
import nl.quintor.simplecalculator.web.rest.dto.CalculationResultDto;
import nl.quintor.simplecalculator.web.transformer.CalculationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CalculatorController calculatorController;

    @Mock
    private CalculatorService calculatorService;

    @Mock
    private CalculationMapper calculateTransformer;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    public void calculateTest() throws Exception {
        int leftOperand = 20;
        Operator operator = Operator.Multiply;
        int rightOperand = 5;
        double expectedResult = 100;

        var calculationDto = new CalculationDto();
        calculationDto.setLeftOperand(leftOperand);
        calculationDto.setOperator(operator);
        calculationDto.setRightOperand(rightOperand);

        var calculation = new Calculation()
                .setLeftOperand(leftOperand)
                .setOperator(operator)
                .setRightOperand(rightOperand)
                .setResult(expectedResult);

        var calculationResultDto = new CalculationResultDto();
        calculationResultDto.setLeftOperand(leftOperand);
        calculationResultDto.setOperator(operator);
        calculationResultDto.setRightOperand(rightOperand);
        calculationResultDto.setResult(expectedResult);

        when(calculatorService.calculate(anyInt(), any(Operator.class), anyInt())).thenReturn(calculation);
        when(calculateTransformer.CalculationtoCalculationResultDto(any(Calculation.class))).thenReturn(calculationResultDto);

        MockHttpServletResponse response = mockMvc.perform(
                post("/calculator/calculate")
                        .content(objectMapper.writeValueAsString(calculationDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(objectMapper.writeValueAsString(calculationResultDto), response.getContentAsString());
    }

}
