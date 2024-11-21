package com.ms.user.producer;

import com.ms.user.domain.UserModel;
import com.ms.user.domain.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessage(UserModel userModel){
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setSubject("Cadastro realizado com sucesso!");
        emailDTO.setText(userModel.getName() + ", seja bem-vindo(a)! \nAgradecemos pelo seu cadastro, aproveite todos os recursos da plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
