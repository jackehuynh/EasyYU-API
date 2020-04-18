package com.easyyu.exceptions;

import com.easyyu.exceptions.customexceptions.InvalidParameterException;
import com.easyyu.exceptions.customexceptions.NotFoundException;
import org.hibernate.QueryParameterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@RestControllerAdvice(basePackages = "com.easyyu.api")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public Timestamp createTimeStamp() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        return timestamp;
    }

    // 404
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponse handleNotFoundException(NotFoundException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setTimeStamp(createTimeStamp());
        response.setStatus(HttpStatus.NOT_FOUND.value());

        return response;
    }

    // 422
    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(request.getContextPath());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(createTimeStamp());
        response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // 400
    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidParameterException(InvalidParameterException ex, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setTimeStamp(createTimeStamp());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setPath(request.getRequestURI());

        System.out.println("uri: " + request.getRequestURI());
        System.out.println("path: " + request.getPathInfo());
        System.out.println("url: " + request.getRequestURL());


        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
