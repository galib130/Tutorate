package com.example.test_spring;

import com.example.test_spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.example.test_spring.repository.userRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
//@SpringBootApplication
public class TestSpringApplication implements CommandLineRunner {



    public static void main(String[] args) {



        SpringApplication.run(TestSpringApplication.class, args);
    }
@Autowired
private userRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
//        this.userRepository.save(new User("Galib"));
//        this.userRepository.save(new User("nakib"));
//        User user=new User();
//        user.setName("labbi");
//        user.setId(2);
//        userRepository.save(user);
//
//        User user1 = new User();
//        user1.setName("nagib");
//        userRepository.save(user1);
    }


}
