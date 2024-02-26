package edu.icet.controller;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrower")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/add")
    public void add(@RequestBody User user){
        service.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
       service.deleteUser(id);
    }

    @GetMapping("/get")
    public List<UserEntity> getUsers(){
        return service.getUsers();
    }
}
