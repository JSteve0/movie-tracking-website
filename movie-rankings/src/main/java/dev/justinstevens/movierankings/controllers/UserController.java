package dev.justinstevens.movierankings.controllers;

import dev.justinstevens.movierankings.documents.Movie;
import dev.justinstevens.movierankings.documents.User;
import dev.justinstevens.movierankings.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/find-all")
    List<User> findAll() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> user.setPassword(""));
        return users;
    }

    @GetMapping("/find-by-username/{username}")
    User findByUsername(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        user.setPassword("");
        return user;
    }

    @GetMapping("/find-by-email/{email}")
    User findByEmail(@PathVariable("email") String email) {
        User user = userRepository.findByEmail(email);
        user.setPassword("");
        return user;
    }

    @GetMapping("/login")
    User login(
            @RequestParam String email,
            @RequestParam String password)
    {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                user.setPassword(null);
                return user;
            } else {
                return null;
            }
        }

        return null;
    }

    @PostMapping("/create-user")
    ResponseEntity<String> upsertUser(@RequestBody User newUser) {

        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is Taken.");
        }
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email is Taken");
        }

        newUser.setId(null);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);

        return ResponseEntity.ok("User Created");
    }

    @PostMapping("/add-movies")
    ResponseEntity<String> upsertMovie(
            @RequestParam String email,
            @RequestParam String password,
            @RequestBody List<Movie> movies)
    {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.badRequest().body("Unauthorized");
        }

        movies.forEach(movie -> {
            if (movie.getRating() == 0) {
                movie.setRating(1000);
            }
            movie.setId(Integer.toString(movie.hashCode()));
        });
        if (user.getMovies() == null) {
            user.setMovies(movies);
        } else {
            user.getMovies().addAll(movies);
        }
        userRepository.save(user);
        return ResponseEntity.ok("Movie(s) added");
    }

}
