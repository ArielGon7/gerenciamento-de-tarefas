package com.devariel.gerenciamento_de_tarefas.exception;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(Long id){super("Not found Task with id: "+id);}

}
