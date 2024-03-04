package edu.icet.controller;

import edu.icet.dto.Login;
import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.service.LoginService;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    final UserService service;
    final LoginService loginService;
    @PostMapping("/add")
    public void add(@RequestBody User user){
        service.saveUser(user);
        loginService.insertLoginData(new Login(user.getEmail(),user.getPassword()));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
       service.deleteUser(id);
    }

    @GetMapping("/get")
    public Iterable<UserEntity> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/find-by-userName/{userName}")
    public User findByUserName(@PathVariable("userName") String userName){
        return service.findByUserName(userName);
    }

    @GetMapping("/exist-by-userName/{userName}")
    public Boolean existsByUserName(@PathVariable("userName")String userName){
        return service.existsByUserName(userName);
    }
}
