package com.cydeo.lab08rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionWrapper {
    public String message;
    public HttpStatus httpStatus;
private Integer errorCount;
private List<ValidationError> validationErrorList;
    public ExceptionWrapper(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    private LocalDateTime timestap;

//    public ExceptionWrapper(String message, HttpStatus httpStatus, LocalDateTime timestap) {
//        this.message = message;
//        this.httpStatus = httpStatus;
//        this.timestap = timestap;
//    }
}
