package nl.quintor.simplecalculator.web.transformer;

import javax.annotation.processing.Generated;
import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.web.rest.dto.CalculationDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-11T17:53:45+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class CalculationMapperImpl implements CalculationMapper {

    @Override
    public CalculationDto CalculationtoCalculationDto(Calculation calculate) {
        if ( calculate == null ) {
            return null;
        }

        CalculationDto calculationDto = new CalculationDto();

        calculationDto.setId( calculate.getId() );
        calculationDto.setX( calculate.getX() );
        calculationDto.setOperator( calculate.getOperator() );
        calculationDto.setY( calculate.getY() );
        calculationDto.setResult( calculate.getResult() );

        return calculationDto;
    }
}
