package com.easyyu.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.Date;

@RestControllerAdvice(basePackages = "com.easyyu.api")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // 404
    @ExceptionHandler(ExceptionType.PageNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlePageNotFoundException(Exception ex) {
        ExceptionResponse response = getResponse(HttpStatus.NOT_FOUND.value(), "requested path not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // 422
    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse response = getResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // 400
    @ExceptionHandler(ExceptionType.InvalidParameterException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidParameterException(Exception ex) {
        String query = getCurrentHttpRequest().getQueryString();
        ExceptionResponse response = getResponse(HttpStatus.BAD_REQUEST.value(), String.format("query '%s' is not supported", query));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 400
    // TODO: possibly not a 400 request and refactor InvalidParameterException from ExceptionType
    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidParamException(Exception ex) {
        HttpServletRequest req = getCurrentHttpRequest();
        ExceptionResponse response = getResponse(HttpStatus.BAD_REQUEST.value(), "incorrect parameter(s), please refer to the documentation " + req.getParameter(ex.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 401
    @ExceptionHandler(ExceptionType.UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedException(Exception ex) {
        ExceptionResponse response = getResponse(HttpStatus.UNAUTHORIZED.value(), "authorization required");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    // 403
    @ExceptionHandler(ExceptionType.InvalidTokenException.class)
    public ResponseEntity<ExceptionResponse> handleForbiddenException(Exception ex) {
        ExceptionResponse response = getResponse(HttpStatus.FORBIDDEN.value(), "permission denied");
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
    public Timestamp createTimeStamp() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        return timestamp;
    }

    public static HttpServletRequest getCurrentHttpRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            return request;
        }
        return null;
    }

    public ExceptionResponse getResponse(int status, String message) {
        HttpServletRequest request = getCurrentHttpRequest();
        ExceptionResponse res = new ExceptionResponse();
        res.setMessage(message);
        res.setTimeStamp(createTimeStamp());
        res.setStatus(status);
        res.setPath(request.getRequestURI());
        return res;
    }
}
