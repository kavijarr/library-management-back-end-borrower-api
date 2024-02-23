package edu.icet.service;

import edu.icet.dto.User;

public interface UserService {
    void saveUser(User user);

    boolean deleteUser(Long id);
}
