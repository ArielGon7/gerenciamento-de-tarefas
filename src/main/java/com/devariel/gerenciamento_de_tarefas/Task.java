package com.devariel.gerenciamento_de_tarefas;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tittle")
    private String tittle;

    @Column(name = "Description")
    private String description;

    @Column(name = "Completed")
    private Boolean completed;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

}