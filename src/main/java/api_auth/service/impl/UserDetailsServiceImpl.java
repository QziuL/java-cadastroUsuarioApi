package api_auth.service.impl;

import api_auth.model.User;
import api_auth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
           Método da interface UserDetailsService que irá carregar
           os dados do usuário com base no username passado, retornando
           um UserDetails. Este método é chamado automaticamente
           no processo de autenticação.
         */

        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("Usuário não encontrado."));
        return new UserDetailsImpl(user);
    }
}
