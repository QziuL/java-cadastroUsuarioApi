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

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody UserDTO userDTO) {
        User userCreated = userService.insert(userDTO);
        System.out.println(userCreated);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
