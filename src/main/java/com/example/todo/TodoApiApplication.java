package com.example.todo;

import java.time.Clock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoApiApplication.class, args);
  }

  /** Reloj inyectable: permite fijar la fecha en los tests. */
  @Bean
  public Clock reloj() {
    return Clock.systemDefaultZone();
  }
}
