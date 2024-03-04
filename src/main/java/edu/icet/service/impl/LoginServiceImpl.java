package edu.icet.service.impl;

import edu.icet.dto.Login;
import edu.icet.entity.LoginEntity;
import edu.icet.repository.LoginRepository;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {
    final LoginRepository repository;
    final ModelMapper mapper;
    @Override
    public void insertLoginData(Login login) {
        repository.save(mapper.map(login, LoginEntity.class));
    }

    @Override
    public Boolean validateLogin(Login login) {
        log.info(login.toString());
        return repository.existsByEmailAndPassword(login.getEmail(), login.getPassword());
    }
}
