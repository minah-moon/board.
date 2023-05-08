package com.example.board.repository;

import com.example.board.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTests {
  @Autowired
  private UserRepository userRepository;
  @Test
  public void insertUsers() {
    IntStream.rangeClosed(1, 100).forEach(i -> {
        User user = User.builder()
            .email("user"+i +"@aaa.com")
            .password("1111")
            .name("USER"+i)
            .build();
        userRepository.save(user);
    });
  }
}