package com.priya.com;


import org.springframework.stereotype.Component;

@Component
public class UserService {
 private final UserDetails userdetails;

 public UserService (UserDetails userdetails){this.userdetails=userdetails;}

 public User getUserById(int id){
     return userdetails.findById(id). orElseThrow(() -> new RuntimeException("User not found"));



}


}

