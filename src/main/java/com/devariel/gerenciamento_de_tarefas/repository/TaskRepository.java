package com.devariel.gerenciamento_de_tarefas.repository;

import com.devariel.gerenciamento_de_tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


}
