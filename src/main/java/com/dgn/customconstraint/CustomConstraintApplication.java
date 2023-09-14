package com.dgn.customconstraint;

import com.dgn.customconstraint.model.User;
import com.dgn.customconstraint.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomConstraintApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public CustomConstraintApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomConstraintApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User("dogan", "905555555555");
        userRepository.save(user);

    }
}
