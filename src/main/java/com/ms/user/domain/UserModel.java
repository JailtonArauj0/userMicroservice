package com.ms.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Jailton Araujo
 **/

@Entity
@Table(name = "tb_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -6282565094223928752L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String email;

    public UserModel(UserDTO userDTO){
        this.name = userDTO.name();

    }
}
