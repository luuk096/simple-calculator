package nl.quintor.simplecalculator.web.transformer;

import javax.annotation.processing.Generated;
import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.web.rest.dto.CalculationResultDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-12T19:01:58+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class CalculationMapperImpl implements CalculationMapper {

    @Override
    public CalculationResultDto CalculationtoCalculationResultDto(Calculation calculate) {
        if ( calculate == null ) {
            return null;
        }

        CalculationResultDto calculationResultDto = new CalculationResultDto();

        calculationResultDto.setId( calculate.getId() );
        calculationResultDto.setLeftOperand( (int) calculate.getLeftOperand() );
        calculationResultDto.setOperator( calculate.getOperator() );
        calculationResultDto.setRightOperand( (int) calculate.getRightOperand() );
        calculationResultDto.setResult( calculate.getResult() );

        return calculationResultDto;
    }
}
