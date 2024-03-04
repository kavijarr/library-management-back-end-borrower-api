package edu.icet.controller;

import edu.icet.dto.Login;
import edu.icet.repository.LoginRepository;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
@RequiredArgsConstructor
public class LoginController {
    final LoginService service;
    @PostMapping("/request-login")
    public Boolean validateLogin(@RequestBody Login login){
        return service.validateLogin(login);
    }
}
