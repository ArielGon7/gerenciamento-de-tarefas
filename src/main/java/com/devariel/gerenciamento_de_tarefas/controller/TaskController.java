package com.devariel.gerenciamento_de_tarefas.controller;

import com.devariel.gerenciamento_de_tarefas.model.Task;
import com.devariel.gerenciamento_de_tarefas.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    public final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        Task taskPrimary = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskPrimary);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTask(){
        return ResponseEntity.ok(taskService.findAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.findByIdTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTask(@RequestBody Task task){
        taskService.deleteTask(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> completedTask(@PathVariable Long id){
        taskService.completedTask(id);
        return ResponseEntity.noContent().build();
    }

}
