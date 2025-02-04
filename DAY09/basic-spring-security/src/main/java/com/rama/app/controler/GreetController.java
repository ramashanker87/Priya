package com.rama.app.controler;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

  @GetMapping("/greet")
  public String greet() {
    return "Greet World";
  }
  @PostMapping("/hello")
  public String hello() {
    return "Hello World";
  }
  @PutMapping("/hi")
  public String hi() {
    return "Hi World";
  }
  @DeleteMapping("/thanks")
  public String thanks() {
    return "Thanks World";
  }
}
