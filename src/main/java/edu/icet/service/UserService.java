package edu.icet.service;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    boolean deleteUser(Long id);

    List<UserEntity> getUsers();

    User findByUserName(String userName);

    Boolean existsByUserName(String userName);
}
