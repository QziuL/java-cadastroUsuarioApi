package api_auth.service.impl;

import api_auth.dto.UserDTO;
import api_auth.model.User;
import api_auth.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Override
    public UserDTO insert(UserDTO user) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return List.of();
    }

    @Override
    public UserDTO getById(UUID id) {
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
