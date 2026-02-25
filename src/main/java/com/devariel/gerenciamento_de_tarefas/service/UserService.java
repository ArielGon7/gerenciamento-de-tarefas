package com.devariel.gerenciamento_de_tarefas.service;

import com.devariel.gerenciamento_de_tarefas.model.User;
import com.devariel.gerenciamento_de_tarefas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public User userSave(String username, String password){
        String encryptedPassword = passwordEncoder.encode(password);
        User user = new User(username, encryptedPassword);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
