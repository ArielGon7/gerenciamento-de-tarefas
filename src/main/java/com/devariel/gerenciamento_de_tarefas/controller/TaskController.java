package com.devariel.gerenciamento_de_tarefas.controller;

import com.devariel.gerenciamento_de_tarefas.dto.TaskRequestDto;
import com.devariel.gerenciamento_de_tarefas.dto.TaskResponseDto;
import com.devariel.gerenciamento_de_tarefas.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> saveTask(@RequestBody @Valid TaskRequestDto requestDto){
        TaskResponseDto taskResponseDto = taskService.saveTask(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> findAllTask(){
        return ResponseEntity.ok(taskService.findAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.findByIdTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @RequestBody @Valid TaskRequestDto requestDto){
        return ResponseEntity.ok(taskService.updateTask(id, requestDto));
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
