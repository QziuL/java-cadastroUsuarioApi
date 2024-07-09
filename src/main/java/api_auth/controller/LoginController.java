package api_auth.controller;

import api_auth.config.jwt.JwtCreator;
import api_auth.config.jwt.JwtObject;
import api_auth.config.jwt.JwtSecurityConfig;
import api_auth.dto.LoginDTO;
import api_auth.dto.SessaoDTO;
import api_auth.model.User;
import api_auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtSecurityConfig jwtSecurityConfig;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public SessaoDTO login(@RequestBody LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername()).orElse(null);

        if(Objects.isNull(user))
           throw new IllegalArgumentException("User not found for login: " + loginDTO.getUsername());

        if (!encoder.matches(loginDTO.getPassword(), user.getPassword()))
            throw new IllegalArgumentException("Invalid password for login: " + loginDTO.getUsername());

        SessaoDTO sessaoDTO = new SessaoDTO();
        JwtObject jwtObject = new JwtObject();

        // definição dos atributos de JwtObject
        jwtObject.setSubject(user.getUsername());
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiresAt(new Date(System.currentTimeMillis() + jwtSecurityConfig.EXPIRATION));
        jwtObject.setRoles(user.getRoles().toString());

        // definição dos atributos de SessaoDTO
        sessaoDTO.setLogin(loginDTO.getUsername());
        sessaoDTO.setToken(JwtCreator.create(jwtSecurityConfig.PREFIX, jwtSecurityConfig.KEY, jwtObject));
        return sessaoDTO;
    }
}
