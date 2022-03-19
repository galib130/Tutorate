package com.example.test_spring;

import com.example.test_spring.model.User;
import com.example.test_spring.userDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.test_spring.repository.userRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private userRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userRepository.findByName(username);
       if(user==null){
           throw new UsernameNotFoundException("User not found");
       }
       return new userDetail(user);

    }
}
