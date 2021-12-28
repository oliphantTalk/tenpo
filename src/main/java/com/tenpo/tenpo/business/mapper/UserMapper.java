package com.tenpo.tenpo.business.mapper;

import com.tenpo.tenpo.api.session.SignUpRq;
import com.tenpo.tenpo.business.model.User;
import com.tenpo.tenpo.business.session.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO modelToDto(User user);

    UserDTO apiToDto(SignUpRq signUpRq);

    User dtoToModel(UserDTO userDTO);

}
