package com.devariel.gerenciamento_de_tarefas.service;

import com.devariel.gerenciamento_de_tarefas.dto.TaskRequestDto;
import com.devariel.gerenciamento_de_tarefas.dto.TaskResponseDto;
import com.devariel.gerenciamento_de_tarefas.mapper.TaskMapper;
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
    public final TaskMapper taskMapper;

    public TaskResponseDto saveTask(TaskRequestDto requestDto){
        Task entity = taskMapper.toEntity(requestDto);
        entity.setCompleted(false);
        entity.setCreatedAt(LocalDateTime.now());
        Task save = taskRepository.save(entity);
        return taskMapper.toResponse(save);

    }

    public List<TaskResponseDto> findAllTask(){
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(taskMapper::toResponse).toList();
    }

    public TaskResponseDto findByIdTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("id not exist or not found"));
        return taskMapper.toResponse(task);
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto requestDto){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        task.setTitle(requestDto.getTitle());
        task.setDescription(requestDto.getDescription());
        taskRepository.save(task);
        return taskMapper.toResponse(task);
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
