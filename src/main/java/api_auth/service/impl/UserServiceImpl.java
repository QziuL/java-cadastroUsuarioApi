package api_auth.service.impl;

import api_auth.dto.UserDTO;
import api_auth.model.User;
import api_auth.repository.UserRepository;
import api_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private PasswordEncoder encoder(){ return new BCryptPasswordEncoder(); }

    @Override
    public User insert(UserDTO userDTO) {
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword()))
            throw new IllegalArgumentException("Passwords do not match");
        if(userRepository.findByEmail(userDTO.getEmail()).isPresent())
            throw new IllegalArgumentException("Email already exists");
        userDTO.setPassword(encoder().encode(userDTO.getPassword()));
        return userDTO.convertToUser();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(UUID id) {
        return null;
    }

    @Override
    public User updateById(UUID id) {
        return null;
    }

    @Override
    public boolean deleteById(UUID id) {
        return false;
    }
}
