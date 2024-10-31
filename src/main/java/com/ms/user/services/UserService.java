package com.ms.user.services;

import com.ms.user.domain.UserDTO;
import com.ms.user.domain.UserModel;
import com.ms.user.mapper.UserMapper;
import com.ms.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel save(UserDTO userDTO){
        UserModel user = UserMapper.INSTANCE.toModel(userDTO);

        return userRepository.save(user);
    }

    public UserModel getById(UUID id){
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        return userRepository.save(user);
    }
}