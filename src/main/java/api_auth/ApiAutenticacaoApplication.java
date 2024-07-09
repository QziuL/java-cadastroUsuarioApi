package api_auth;

import api_auth.config.jwt.JwtSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 	Estudo de API para autenticação de usuários.
 * 	Projeto inicializado com Spring Initializr.
 * 		Dependências usadas:
 * 		- Spring Web,
 * 		- H2 Database,
 * 		- PostgreSQL Driver,
 * 		- Spring Security,
 * 		- Spring Data JPA
 *
 * @author --> QziuL (Github)
 */

@SpringBootApplication
@EnableConfigurationProperties(JwtSecurityConfig.class)
public class ApiAutenticacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAutenticacaoApplication.class, args);
	}

}
