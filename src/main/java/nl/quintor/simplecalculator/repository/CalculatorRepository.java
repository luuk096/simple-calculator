package nl.quintor.simplecalculator.repository;

import nl.quintor.simplecalculator.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends JpaRepository<Calculation, Long> {



}
