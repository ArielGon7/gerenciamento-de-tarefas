package com.devariel.gerenciamento_de_tarefas.handler;

import com.devariel.gerenciamento_de_tarefas.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> taskNotFoundException(TaskNotFoundException taskNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taskNotFoundException.getMessage());
    }
}
