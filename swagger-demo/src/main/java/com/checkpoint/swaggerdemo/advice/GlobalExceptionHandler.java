package com.checkpoint.swaggerdemo.advice;

import com.checkpoint.swaggerdemo.error.CheckpointError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    // for @Valid to work on beans
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        //Get all errors
        String errorDes = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> {
                    String s= "fieldName - "+x.getField() + " : " + x.getDefaultMessage();
                    return s;
                }).collect(Collectors.joining(" , "));

        CheckpointError checkpointError = getCheckpointError(ex);
        checkpointError.setErrorDescription(errorDes);
        return new ResponseEntity<>(checkpointError, headers, status);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(HttpServletResponse response, Exception ex) throws IOException {
        return new ResponseEntity(getCheckpointError(ex), HttpStatus.BAD_REQUEST);
    }

    private CheckpointError getCheckpointError(Exception exception) {
        CheckpointError checkpointError= new CheckpointError();
        checkpointError.setErrorCode("CKP-100400");
        checkpointError.setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        logger.debug("detailed Message: "+exception.getMessage());
        checkpointError.setStatusMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        checkpointError.setErrorDescription(exception.getMessage());
        return checkpointError;
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity springHandleNotFound(HttpServletResponse response,Exception exception) throws IOException {
        return new ResponseEntity(getCheckpointError(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RuntimeException.class})
    public void handleRunTimeException(HttpServletResponse response, Exception ex) throws IOException {
        logger.debug("Exception occurred ", ex);
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
    @ExceptionHandler({ConstraintDeclarationException.class})
    public ResponseEntity handleConstraintDeclarationException(HttpServletResponse response, Exception ex) throws IOException {
        logger.debug("Exception occurred ", ex);
        logger.debug("", response.getStatus());
        return new ResponseEntity(getCheckpointError(ex), HttpStatus.BAD_REQUEST);

    }

   /* @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)
    {
        return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
