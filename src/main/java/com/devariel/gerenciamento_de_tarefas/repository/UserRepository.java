package com.devariel.gerenciamento_de_tarefas.repository;

import com.devariel.gerenciamento_de_tarefas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
