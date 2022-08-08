package com.lbd.projectlbd.apierror;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter @Getter
public class ApiErrorResponse {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiError> apiErrorList = new ArrayList<>();

    public ApiErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorResponse(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }


    /**
     * */
    private void addError(ApiError error) {
        apiErrorList.add(error);
    }

    public void addValidationError(String objectName, String message) {
        addError(new ApiValidationError(objectName, message));
    }

    public void addValidationError(String objectName, String fieldName, Object rejectedValue, String message) {
        addError(new ApiValidationError(objectName, fieldName, rejectedValue, message));
    }

    public void addValidationError(ObjectError objectError) {
        if (objectError != null)
            addValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
    }

    public void addValidationError(FieldError fieldError) {
        if (fieldError != null)
            addValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
    }

    public void addValidationErrors(List<FieldError> fieldErrorList) {
        fieldErrorList.forEach(this::addValidationError);
    }

    /**
     * */
    public ResponseEntity<Object> buildResponseEntity() {
        return ResponseEntity.status(this.getStatus()).header("successful", "false").body(this);
    }





}
