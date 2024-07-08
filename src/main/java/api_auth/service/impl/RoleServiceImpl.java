package api_auth.service.impl;

import api_auth.dto.RoleDTO;
import api_auth.model.Role;
import api_auth.repository.RoleRepository;
import api_auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role insert(RoleDTO roleDTO) {
        return roleRepository.save(roleDTO.convertToRole());
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
