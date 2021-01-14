package nl.quintor.simplecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SimpleCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCalculatorApplication.class, args);
	}

}
