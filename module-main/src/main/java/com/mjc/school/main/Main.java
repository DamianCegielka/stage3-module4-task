package com.mjc.school.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing
@EnableJpaRepositories("com.mjc.school.repository")
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }
}
