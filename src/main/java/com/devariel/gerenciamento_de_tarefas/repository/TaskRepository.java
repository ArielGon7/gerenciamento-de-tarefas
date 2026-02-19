package com.devariel.gerenciamento_de_tarefas.repository;

import com.devariel.gerenciamento_de_tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
