package com.ms.user.mapper;

import com.ms.user.domain.UserDTO;
import com.ms.user.domain.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserModel toModel(UserDTO userDTO);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserDTO toDTO(UserModel userModel);
}
