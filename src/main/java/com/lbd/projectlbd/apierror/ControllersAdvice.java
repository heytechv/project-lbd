package com.lbd.projectlbd.apierror;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllersAdvice extends ResponseEntityExceptionHandler {


    Logger logger = LoggerFactory.getLogger(ControllersAdvice.class);


    /** Dla @Valid */
    @Override protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        logger.warn("SIEMAXD");

        ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Validation error", ex);
        errorResponse.addValidationError(ex.getBindingResult().getGlobalError());
        errorResponse.addValidationErrors(ex.getBindingResult().getFieldErrors());
        return errorResponse.buildResponseEntity();
    }
}
