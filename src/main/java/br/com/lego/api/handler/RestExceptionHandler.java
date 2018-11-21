package br.com.lego.api.handler;

import br.com.lego.api.erros.ErrorDetails;
import br.com.lego.api.erros.ResourceNotFoundException;
import br.com.lego.api.erros.ResourceNotFountDetails;
import br.com.lego.api.erros.ValidatorErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFountException(ResourceNotFoundException rfnException) {
        ResourceNotFountDetails rnfDetails = ResourceNotFountDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not Fount")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {

        List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining());
        ValidatorErrorDetails manvDetails = ValidatorErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Field Validator Error")
                .detail("Field Validator Error")
                .developerMessage(manvException.getClass().getName())
                .field(fields)
                .fieldMessage(fieldMessage)
                .build();

        return new ResponseEntity<>(manvDetails, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(status.value())
                .title("Internal Exception")
                .detail(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(errorDetails, headers, status);
    }
}