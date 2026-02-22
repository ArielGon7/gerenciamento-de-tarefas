package com.devariel.gerenciamento_de_tarefas.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponseDto {

    private Long id;

    private String title;

    private String description;

    private Boolean completed;

    private LocalDateTime createdAt;

}
