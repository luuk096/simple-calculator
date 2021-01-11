package nl.quintor.simplecalculator.web.transformer;

import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.web.rest.dto.CalculationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculationMapper {

    CalculationDto CalculationtoCalculationDto(Calculation calculate);

}
