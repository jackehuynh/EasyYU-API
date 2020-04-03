package com.easyyu.exceptions.customexceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class MissingQueryException extends RuntimeException {
}
