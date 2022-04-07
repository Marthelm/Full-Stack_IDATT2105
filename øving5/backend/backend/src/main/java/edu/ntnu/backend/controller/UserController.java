package edu.ntnu.backend.controller;

import edu.ntnu.backend.model.User;
import edu.ntnu.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<String> doLogin(@RequestBody User user) {
        try {
            User u = userRepository.findUserByUsername(user.getUsername());
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                return new ResponseEntity<>("success", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("failed",HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
