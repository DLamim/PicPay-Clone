package br.com.dlm.picpayclone.mapper;

import br.com.dlm.picpayclone.dto.UserDTO;
import br.com.dlm.picpayclone.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends MapperBase<User, UserDTO>{

    @Override
    public UserDTO mapEntityToDto(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User mapDtoToEntity(UserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UserDTO, User>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(dto, User.class);
    }
}
