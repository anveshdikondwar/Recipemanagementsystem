package com.Anvesh.Recipemanagementsystem.controller;

import com.Anvesh.Recipemanagementsystem.dto.SignInInput;
import com.Anvesh.Recipemanagementsystem.dto.SignInOutput;
import com.Anvesh.Recipemanagementsystem.dto.SignUpInput;
import com.Anvesh.Recipemanagementsystem.dto.SignUpOutput;
import com.Anvesh.Recipemanagementsystem.model.User;
import com.Anvesh.Recipemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
