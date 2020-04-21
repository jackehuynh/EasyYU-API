package com.easyyu.exceptions;

// holds various exceptions in a single class
public class ExceptionType {

    public static class PageNotFoundException extends RuntimeException { }
    public static class InvalidParameterException extends RuntimeException { }
    public static class UnauthorizedException extends RuntimeException { }
    public static class InvalidTokenException extends RuntimeException { }

}
