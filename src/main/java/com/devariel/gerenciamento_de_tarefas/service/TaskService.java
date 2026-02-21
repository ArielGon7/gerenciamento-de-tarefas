package com.devariel.gerenciamento_de_tarefas.service;

import com.devariel.gerenciamento_de_tarefas.model.Task;
import com.devariel.gerenciamento_de_tarefas.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    public final TaskRepository taskRepository;

    public Task saveTask(Task task){
        task.setCompleted(false);
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public Task findByIdTask(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("id not exist or not found"));
    }

    public Task updateTask(Long id, Task task){
        Task taskPrimary = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        taskPrimary.setTittle(task.getTittle());
        taskPrimary.setDescription(task.getDescription());
        return taskRepository.save(taskPrimary);
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

    public void completedTask(Long id){
        Task taskPrimary = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        taskPrimary.setCompleted(true);
        taskRepository.save(taskPrimary);
    }
}
