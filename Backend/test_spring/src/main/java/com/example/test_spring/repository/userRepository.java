package com.example.test_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.test_spring.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM student  where name=:name",nativeQuery = true)
        List<User> findUser(@Param("name") String name);

    @Query(value = "select password from student where name=:name",nativeQuery=true)
        String findPassword(String name);
    @Query(value = "Select id from student where name=:name",nativeQuery = true)
            Integer findIdByName(@Param("name") String name);


    User findByName(String username);

}
