package edu.icet.service.impl;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    final UserRepository repository;
    final ModelMapper mapper;
    @Override
    public void saveUser(User user) {
        UserEntity userEntity = mapper.map(user,UserEntity.class);
        repository.save(userEntity);
        log.info(user.toString());
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

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) repository.findAll();
    }


    public User findByUserName(String userName){
        UserEntity entity = repository.findByUserName(userName);
        User user = mapper.map(entity, User.class);
        return user;
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return repository.existsByUserName(userName);
    }
}
