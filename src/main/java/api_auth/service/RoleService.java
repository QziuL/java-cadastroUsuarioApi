package api_auth.service;

import api_auth.dto.RoleDTO;
import api_auth.model.Role;

import java.util.List;

public interface RoleService {
    Role insert(RoleDTO role);
    List<Role> getAll();
}
