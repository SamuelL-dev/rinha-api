package rinha.backend.api.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rinha.backend.api.exceptionHandler.commonStandardError.StandardError;
import rinha.backend.domain.customException.ClientNotFoundException;
import rinha.backend.domain.customException.InsufficientDebitBalanceException;

import java.time.Instant;


@RestControllerAdvice
@RequiredArgsConstructor
public class RequestHandlerException {
    private final Logger logger = LoggerFactory.getLogger(RequestHandlerException.class);

    @ExceptionHandler(InsufficientDebitBalanceException.class)
    private ResponseEntity<StandardError> handleinsufficientDebitBalanceException(InsufficientDebitBalanceException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        log(ex);
        return handlerException(ex, status, request, ex.getMessage());
    }


    @ExceptionHandler(ClientNotFoundException.class)
    private ResponseEntity<StandardError> handleClientNotFoundException(ClientNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return handlerException(ex, status, request, ex.getMessage());
    }

// HttpMessageNotReadableException
    private ResponseEntity<StandardError> handlerException(Exception ex, HttpStatus status, HttpServletRequest request, String error) {
        StandardError err = new StandardError(Instant.now(), status.value(), ex.getMessage(), request.getRequestURI());
        log(ex);
        return ResponseEntity.status(status).body(err);
    }



    private void log(Throwable ex) {
        logger.error("error message {}. Details: ", ex.getMessage(), ex);
    }

}
