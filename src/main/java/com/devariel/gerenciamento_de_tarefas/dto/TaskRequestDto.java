package com.devariel.gerenciamento_de_tarefas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequestDto {

    @NotBlank(message = "tittle not found")
    private String title;

    @NotBlank(message = "description is required")
    private String description;
}
