package com.cxtx.controller;

import com.cxtx.exception.ParameterInvalidException;
import com.cxtx.service.impl.StorageFileNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jinchuyang on 16/10/19.
 */
@RequestMapping("/api")
public abstract class ApiController {


    protected void checkParameter(boolean condition, Object errorMessage) {
        if (!condition) {
            throw new ParameterInvalidException(errorMessage);
        }
    }
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
