package nl.quintor.simplecalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class SimpleCalculatorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationExceptionHandler(ConstraintViolationException exception, WebRequest request) {
        List<SimpleCalculatorHttpErrorMessage> body = new ArrayList<>();
        for (ConstraintViolation e: exception.getConstraintViolations()) {
            SimpleCalculatorHttpErrorMessage currentException = new SimpleCalculatorHttpErrorMessage(
                    e.getPropertyPath().iterator().next().getName(),
                    "constraint",
                    e.getConstraintDescriptor().getMessageTemplate());
            body.add(currentException);
        }
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
