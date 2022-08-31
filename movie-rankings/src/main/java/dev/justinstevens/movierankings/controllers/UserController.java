package dev.justinstevens.movierankings.controllers;

import dev.justinstevens.movierankings.documents.User;
import dev.justinstevens.movierankings.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/find-all")
    List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/find-by-username/{username}")
    User findByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

    @GetMapping("/find-by-email/{email}")
    User findByEmail(@PathVariable("email") String email) {
        return userRepository.findByUsername(email);
    }

    @PostMapping("/create-user")
    User upsertUser(@RequestBody User newUser) {
        newUser.setId(null);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

}
