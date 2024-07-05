package api_auth.service;

import api_auth.dto.UserDTO;
import api_auth.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO insert(UserDTO user);
    List<UserDTO> getAll();
    UserDTO getById(UUID id);
    User updateById(UUID id);
    boolean deleteById(UUID id);
}
