package edu.icet.service;

import edu.icet.dto.Login;

public interface LoginService {
    void insertLoginData(Login login);
    Boolean validateLogin(Login login);
}
