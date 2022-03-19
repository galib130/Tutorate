package com.example.test_spring.model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;



@Entity
@Table(name = "student")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private long  id;
    @Column(name="name")
        private String name;

    @Column(name = "last_name")
    private String last_name;

    private String password;
    //private String role;
    public User() {

    }
    public User(String name ){

        super();

        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Id
    public long getId() {
        return id;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
}
