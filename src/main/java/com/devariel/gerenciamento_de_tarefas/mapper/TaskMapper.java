package com.devariel.gerenciamento_de_tarefas.mapper;

import com.devariel.gerenciamento_de_tarefas.dto.TaskRequestDto;
import com.devariel.gerenciamento_de_tarefas.dto.TaskResponseDto;
import com.devariel.gerenciamento_de_tarefas.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    Task toEntity(TaskRequestDto requestDto);

    TaskResponseDto toResponse(Task task);


}
