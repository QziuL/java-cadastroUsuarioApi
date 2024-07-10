package api_auth.controller;

import api_auth.dto.UserDTO;
import api_auth.model.User;
import api_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/auth")
    public ResponseEntity<String> authenticate() {
        return new ResponseEntity<>("Usuário autorizado", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody UserDTO userDTO) {
        User userCreated = userService.insert(userDTO);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<User> deleteUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userService.deleteByEmail(email), HttpStatus.OK);
    }
}
