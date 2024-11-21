package com.ms.user.services;

import com.ms.user.domain.UserDTO;
import com.ms.user.domain.UserModel;
import com.ms.user.mapper.UserMapper;
import com.ms.user.producer.UserProducer;
import com.ms.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserDTO userDTO) {
        UserModel user = UserMapper.INSTANCE.toModel(userDTO);
        user = userRepository.save(user);
        userProducer.publishMessage(user);
        return user;
    }

    public UserModel getById(UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        return userRepository.save(user);
    }
}