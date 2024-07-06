package api_auth.service.impl;

import api_auth.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 *  Definição de como os detalhes do usuário serão obtidos e validados.
 *  Agregado com JWT.
 */

public class UserDetailsImpl implements UserDetails {
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
         Este método converte a lista de roles associadas ao
         usuário em uma coleção de GrantedAuthorities, que é a
         forma do Spring Security de interpretar roles (papéis).
         Isso é feito mapeando cada role para um novo SimpleGrantedAuthority,
         uma implementação mais simples de GrantedAuthorities.
        */
        return user
                .getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
