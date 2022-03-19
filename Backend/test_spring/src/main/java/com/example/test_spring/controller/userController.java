package com.example.test_spring.controller;

import com.example.test_spring.UserService;
import com.example.test_spring.model.User;
import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.test_spring.repository.userRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/")
public class userController {

    @Autowired
    private userRepository userRepository;


    @GetMapping("user")
    public List<User> getUser(){
return  this.userRepository.findAll();

    }
@PostMapping("return")
    public String createUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws IOException {

    System.out.println("hi1");
    System.out.println("hi2");
    //UserService userService=new UserService();
    //userService.loadUserByUsername(user.getName());
    System.out.println(user.getName());

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    if(userRepository.findUser(user.getName()).isEmpty()){
        System.out.println(encoder.encode(user.getPassword()));

        System.out.println("User not registered");

        return "not authenticated";
    }
    else
    {
        if(encoder.matches(user.getPassword(),userRepository.findPassword(user.getName()))){
            System.out.println("User registered");
            HttpSession session=request.getSession();

        session.setAttribute("session id",userRepository.findIdByName(user.getName()));
            System.out.println(session.getAttribute("session id"));
                return "authenticated";
        }

    }

                return "not valid";
        }


}
