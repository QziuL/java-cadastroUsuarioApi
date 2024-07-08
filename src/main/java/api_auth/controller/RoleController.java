package api_auth.controller;

import api_auth.dto.RoleDTO;
import api_auth.model.Role;
import api_auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(roleService.insert(roleDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }
}
