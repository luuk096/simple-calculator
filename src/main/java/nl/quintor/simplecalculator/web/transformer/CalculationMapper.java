package nl.quintor.simplecalculator.web.transformer;

import nl.quintor.simplecalculator.model.Calculation;
import nl.quintor.simplecalculator.web.rest.dto.CalculationResultDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculationMapper {

    CalculationResultDto CalculationtoCalculationResultDto(Calculation calculate);

}
