package edu.icet.service.impl;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    ModelMapper mapper;
    @Override
    public void saveUser(User user) {
        UserEntity userEntity = mapper.map(user,UserEntity.class);
        repository.save(userEntity);

    }

    @Override
    public boolean deleteUser(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Bean
    public void setup(){
        this.mapper=new ModelMapper();
    }
}
