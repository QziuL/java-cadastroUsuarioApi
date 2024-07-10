package api_auth.service;

import api_auth.dto.UserDTO;
import api_auth.model.User;

import java.util.List;

public interface UserService {
    User insert(UserDTO user);
    List<User> findAll();
    User getByEmail(String email);
    //User updateByEmail(String email);
    User deleteByEmail(String email);
}
